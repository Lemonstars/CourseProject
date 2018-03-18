package cn.edu.nju.software.onlineexamsystem.service.impl;

import cn.edu.nju.software.onlineexamsystem.entity.*;
import cn.edu.nju.software.onlineexamsystem.mapper.*;
import cn.edu.nju.software.onlineexamsystem.service.StatisticsService;
import cn.edu.nju.software.onlineexamsystem.vo.ExamResultVO;
import cn.edu.nju.software.onlineexamsystem.vo.ExamSettingVO;
import cn.edu.nju.software.onlineexamsystem.vo.OptionQuestionAnswerVO;
import cn.edu.nju.software.onlineexamsystem.vo.PaperAfterExamVO;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/10
 */

@Service
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private ExamSettingMapper examSettingMapper;

    @Autowired
    private ExamRecordMapper examRecordMapper;

    @Autowired
    private ExamResultMapper examResultMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SingleOptionMapper singleOptionMapper;

    @Autowired
    private MultiplyOptionMapper multiplyOptionMapper;

    private static final String ABSENT = "缺考";
    private static final String COMMON = "正常";

    @Override
    public XSSFWorkbook generateExamResult(Integer id) {
        List<ExamResultVO> examResultVOList = obtainExamResult(id);
        XSSFWorkbook res = generateExamResultSheet(examResultVOList);

        return res;
    }

    @Override
    public PaperAfterExamVO generatePaperAfterExam(String email, String subject) {
        ExamResultEntity examResultEntity = examResultMapper.findByEmailAndSubject(email, subject);

        OptionQuestionAnswerVO optionQuestionAnswerVO;

        //单选题-包含考生选择
        String singleStudentAnswer = examResultEntity.getSingleOptionStudentAnswer();
        String[] singleStudentAnswerSplit = singleStudentAnswer.split("-");

        List<SingleOptionEntity> singleOptionEntityList = singleOptionMapper.getBySubject(subject);
        Map<Integer, SingleOptionEntity> singleOptionEntityMap = new HashMap<>(singleOptionEntityList.size());
        for(SingleOptionEntity entity:singleOptionEntityList){
            singleOptionEntityMap.put(entity.getId(), entity);
        }

        String singleOptionQuestion = examResultEntity.getSingleOptionQuestion();
        String[] singleOptionQuestionSplit = singleOptionQuestion.split("-");

        List<OptionQuestionAnswerVO> singleOptionAnswerList = new ArrayList<>();
        SingleOptionEntity singleOptionEntity;
        if(!StringUtils.isEmpty(singleOptionQuestionSplit[0])){
            for(int i=0;i<singleOptionQuestionSplit.length;i++){
                String questionId = singleOptionQuestionSplit[i];
                Integer qid = Integer.parseInt(questionId);
                singleOptionEntity = singleOptionEntityMap.get(qid);
                optionQuestionAnswerVO = new OptionQuestionAnswerVO(qid, singleOptionEntity.getQuestion(),
                        singleOptionEntity.getOption1(), singleOptionEntity.getOption2(), singleOptionEntity.getOption3(),
                        singleOptionEntity.getOption4(), singleStudentAnswerSplit[i]);

                singleOptionAnswerList.add(optionQuestionAnswerVO);
            }
        }


        //多选题-包含考生选择
        String multiplyStudentAnswer = examResultEntity.getMultiplyOptionStudentAnswer();
        String[] multiplyStudentAnswerSplit = multiplyStudentAnswer.split("-");

        List<MultiplyOptionEntity> multiplyOptionEntityList = multiplyOptionMapper.getBySubject(subject);
        Map<Integer, MultiplyOptionEntity> multiplyOptionEntityMap = new HashMap<>(multiplyOptionEntityList.size());
        for(MultiplyOptionEntity entity:multiplyOptionEntityList){
            multiplyOptionEntityMap.put(entity.getId(), entity);
        }

        String multiplyOptionQuestion = examResultEntity.getMultiplyOptionQuestion();
        String[] multiplyOptionQuestionSplit = multiplyOptionQuestion.split("-");

        List<OptionQuestionAnswerVO> multiplyOptionAnswerList = new ArrayList<>();
        MultiplyOptionEntity multiplyOptionEntity;
        if(!StringUtils.isEmpty(multiplyOptionQuestionSplit[0])){
            for(int i=0;i<multiplyOptionQuestionSplit.length;i++){
                String questionId = multiplyOptionQuestionSplit[i];
                Integer qid = Integer.parseInt(questionId);
                multiplyOptionEntity = multiplyOptionEntityMap.get(qid);
                optionQuestionAnswerVO = new OptionQuestionAnswerVO(qid, multiplyOptionEntity.getQuestion(),
                        multiplyOptionEntity.getOption1(), multiplyOptionEntity.getOption2(), multiplyOptionEntity.getOption3(),
                        multiplyOptionEntity.getOption4(), multiplyStudentAnswerSplit[i]);

                multiplyOptionAnswerList.add(optionQuestionAnswerVO);
            }
        }


        PaperAfterExamVO paperAfterExamVO = new PaperAfterExamVO(examResultEntity.getSubject(), singleOptionAnswerList, multiplyOptionAnswerList);

        return paperAfterExamVO;
    }

    @Override
    public List<ExamSettingVO> getAllExamSetting() {
        List<ExamSettingEntity> examSettingEntityList = examSettingMapper.getAllExamSetting();
        List<ExamSettingVO> examSettingVOList = new ArrayList<>(examSettingEntityList.size());
        ExamSettingVO vo;
        for(ExamSettingEntity entity: examSettingEntityList){
            vo = new ExamSettingVO(entity.getId(), entity.getSubject(), entity.getSingleOptionCount(),
                    entity.getMultiplyOptionCount(), entity.getPointPerSingleOption(), entity.getPointPerMultiplyOption());
            examSettingVOList.add(vo);
        }

        return examSettingVOList;
    }

    /**
     * 获取所有人的成绩信息
     * @param examSettingId
     * @return
     */
    private List<ExamResultVO> obtainExamResult(Integer examSettingId){

        ExamSettingEntity examSettingEntity = examSettingMapper.findById(examSettingId);
        String subject = examSettingEntity.getSubject();

        //所有应参加考试人的邮箱
        List<String> studentEmails = examRecordMapper.findAllEmailsByExamSettingId(examSettingId);
        //所有参加了考试的学生的信息
        List<ExamResultEntity> studentResultList = examResultMapper.findBySubject(subject);

        //转化为map存储
        Map<String, ExamResultEntity> studentResultMap = new HashMap<>(studentResultList.size());
        for(ExamResultEntity entity: studentResultList){
            studentResultMap.put(entity.getEmail(), entity);
        }

        //生成excel的信息
        List<ExamResultVO> examResultVOList = new ArrayList<>();
        ExamResultVO examResultVO;
        for(String email:studentEmails){
            if(studentResultMap.containsKey(email)){
                ExamResultEntity entity = studentResultMap.get(email);
                examResultVO = new ExamResultVO(entity.getStudentId(), entity.getStudentName(),
                        entity.getEmail(), entity.getStudentPoint(), ExamResultVO.COMMON);
            }else {
                UserEntity userEntity = userMapper.findByEmail(email);
                if(userEntity!=null){
                    examResultVO = new ExamResultVO(userEntity.getStudentId(), userEntity.getName(), userEntity.getEmail(), 0, ExamResultVO.ABSENT);
                }else {
                    examResultVO = new ExamResultVO();
                }
           }
           examResultVOList.add(examResultVO);
        }
        return examResultVOList;
    }

    /**
     * 生成excel成绩单
     * @param examResultVOList
     * @return
     */
    private XSSFWorkbook generateExamResultSheet(List<ExamResultVO> examResultVOList){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("成绩单");

        XSSFRow firstRow = sheet.createRow(0);
        firstRow.createCell(0).setCellValue("学号");
        firstRow.createCell(1).setCellValue("姓名");
        firstRow.createCell(2).setCellValue("邮箱");
        firstRow.createCell(3).setCellValue("成绩");
        firstRow.createCell(4).setCellValue("状态");

        int count = 1;
        XSSFRow currentRow;
        for(ExamResultVO vo: examResultVOList){
            currentRow = sheet.createRow(count);
            currentRow.createCell(0).setCellValue(vo.getStudentId());
            currentRow.createCell(1).setCellValue(vo.getStudentName());
            currentRow.createCell(2).setCellValue(vo.getStudentEmail());
            if(vo.getStatus() == ExamResultVO.ABSENT){
                currentRow.createCell(3).setCellValue(0);
                currentRow.createCell(4).setCellValue(ABSENT);
            }else {
                currentRow.createCell(3).setCellValue(vo.getPoint());
                currentRow.createCell(4).setCellValue(COMMON);
            }
            count ++;
        }

        return workbook;
    }

}
