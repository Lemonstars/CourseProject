package cn.edu.nju.software.onlineexamsystem.service.impl;

import cn.edu.nju.software.onlineexamsystem.entity.*;
import cn.edu.nju.software.onlineexamsystem.form.ExamGenerateForm;
import cn.edu.nju.software.onlineexamsystem.mapper.*;
import cn.edu.nju.software.onlineexamsystem.service.ExamService;
import cn.edu.nju.software.onlineexamsystem.service.MailService;
import cn.edu.nju.software.onlineexamsystem.util.RandomUtil;
import cn.edu.nju.software.onlineexamsystem.vo.ExamGenerateVO;
import cn.edu.nju.software.onlineexamsystem.vo.ExamSettingInfoVO;
import cn.edu.nju.software.onlineexamsystem.vo.OptionQuestionVO;
import cn.edu.nju.software.onlineexamsystem.vo.PaperVO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/03
 */
@Service
public class ExamServiceImpl implements ExamService{

    @Autowired
    private ExamRecordMapper examMapper;

    @Autowired
    private ExamSettingMapper examSettingMapper;

    @Autowired
    private SingleOptionMapper singleOptionMapper;

    @Autowired
    private MultiplyOptionMapper multiplyOptionMapper;

    @Autowired
    private ExamQuestionOrderMapper examQuestionOrderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ExamResultMapper examResultMapper;

    @Autowired
    private StringEncryptor stringEncryptor;

    @Autowired
    private MailService mailService;

    @Override
    public void saveExamSetting(ExamGenerateVO vo) {
        String randomPassword = RandomUtil.random();
        String enPassword = stringEncryptor.encrypt(randomPassword);
        ExamSettingEntity entity = new ExamSettingEntity(vo.getSubject(), vo.getSingleOptionCount(),
                vo.getMultiplyOptionCount(), vo.getPointPerSingleOption(), vo.getPointPerMultiplyOption());
        examSettingMapper.addExamSetting(entity);

        List<String> allEmailList = userMapper.getAllEmails();

        Integer examSettingId = entity.getId();
        List<String> emailList = vo.getEmailList();
        for(String email: emailList){
            if(allEmailList.contains(email)){
                examMapper.addExam(email, examSettingId, vo.getStartTime(), vo.getEndTime(), randomPassword);
                mailService.sendExamRemindEmail(email, vo.getStartTime(), vo.getEndTime(), vo.getSubject(), enPassword);
            }
        }
    }

    @Override
    public void saveExamSettingByExcel(MultipartFile file, String subject, Integer singleOptionCount, Integer multiplyOptionCount,
                                       Integer pointPerSingleOption, Integer pointPerMultiplyOption, String startTime, String endTime){
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            List<String> emailList = getStudentEmailList(workbook);

            ExamGenerateVO examGenerateVO = new ExamGenerateVO(subject, singleOptionCount, multiplyOptionCount,
                    pointPerSingleOption, pointPerMultiplyOption, startTime, endTime, emailList);
            saveExamSetting(examGenerateVO);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public XSSFWorkbook generateStudentSheet() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();

        XSSFRow firstRow = sheet.createRow(0);
        firstRow.createCell(0).setCellValue("考生姓名");
        firstRow.createCell(1).setCellValue("邮箱");

        XSSFRow exampleRow = sheet.createRow(1);
        exampleRow.createCell(0).setCellValue("例如：小明");
        exampleRow.createCell(1).setCellValue("xiaoming@nju.edu.cn");

        return workbook;
    }

    @Override
    public ExamSettingInfoVO validatePassword(String email, String enPassword) {
        ExamSettingInfoVO res = new ExamSettingInfoVO();
        res.setExamSettingId(-1);
        String dePassword = stringEncryptor.decrypt(enPassword);
        int dePasswordInt;
        try {
            dePasswordInt = Integer.parseInt(dePassword);
        }catch (Exception e){
            return res;
        }
        ExamRecordEntity examEntity = examMapper.findByEmailAndPassword(email, dePasswordInt).get(0);

        String startTime = examEntity.getStartTime();
        String endTime = examEntity.getEndTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            Date startTimeFormat  = simpleDateFormat.parse(startTime);
            Date endTimeFormat = simpleDateFormat.parse(endTime);

            Date currentTime = new Date();
            if(currentTime.compareTo(startTimeFormat) < 0){
                res.setExamSettingId(-2);
                return res;
            }

            if(currentTime.compareTo(endTimeFormat) > 0){
                res.setExamSettingId(-3);
                return res;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        res.setExamSettingId(examEntity.getExamSettingId());
        res.setStartTime(examEntity.getStartTime());
        res.setEndTime(examEntity.getEndTime());
        res.setEmail(examEntity.getEmail());
        return res;
    }

    @Override
    public PaperVO generatePaper(Integer examSettingId, String startTime, String endTime, String email) {
        ExamSettingEntity entity = examSettingMapper.findById(examSettingId);

        String subject = entity.getSubject();
        Integer singleLimit = entity.getSingleOptionCount();
        Integer multiplyLimit = entity.getMultiplyOptionCount();

        System.out.println(subject);
        System.out.println(singleLimit);

        List<SingleOptionEntity> singleOptionList = singleOptionMapper.getBySubjectAndLimit(subject, singleLimit);
        List<MultiplyOptionEntity> multiplyOptionList = multiplyOptionMapper.getBySubjectAndLimit(subject, multiplyLimit);

        List<String> singleQuestionOrderList = new ArrayList<>();
        List<String> multiplyQuestionOrderList = new ArrayList<>();

        //单选题
        List<OptionQuestionVO> singleQuestionList = new ArrayList<>();
        for(SingleOptionEntity singleOptionEntity: singleOptionList){
            singleQuestionList.add(new OptionQuestionVO(singleOptionEntity.getId(), singleOptionEntity.getQuestion(),
                    singleOptionEntity.getOption1(), singleOptionEntity.getOption2(), singleOptionEntity.getOption3(),
                    singleOptionEntity.getOption4()));
            singleQuestionOrderList.add(String.valueOf(singleOptionEntity.getId()));
        }

        //多选题
        List<OptionQuestionVO> multiplyQuestionList = new ArrayList<>();
        for(MultiplyOptionEntity multiplyOptionEntity: multiplyOptionList){
            multiplyQuestionList.add(new OptionQuestionVO(multiplyOptionEntity.getId(), multiplyOptionEntity.getQuestion(),
                    multiplyOptionEntity.getOption1(), multiplyOptionEntity.getOption2(), multiplyOptionEntity.getOption3(),
                    multiplyOptionEntity.getOption4()));
            multiplyQuestionOrderList.add(String.valueOf(multiplyOptionEntity.getId()));
        }

        //将考试试题顺序保存至数据库
        StringBuilder singleQuestionOrderString = new StringBuilder();
        for(int i=0;i<singleQuestionOrderList.size();i++){
            if(i == 0){
                singleQuestionOrderString.append(singleQuestionOrderList.get(i));
            }else {
                singleQuestionOrderString.append("-"+singleQuestionOrderList.get(i));
            }
        }
        StringBuilder multiplyQuestionOrderString = new StringBuilder();
        for(int i=0;i<multiplyQuestionOrderList.size();i++){
            if(i == 0){
                multiplyQuestionOrderString.append(multiplyQuestionOrderList.get(i));
            }else {
                multiplyQuestionOrderString.append("-"+multiplyQuestionOrderList.get(i));
            }
        }

        ExamQuestionOrderEntity examQuestionOrderEntity = new ExamQuestionOrderEntity(email, singleQuestionOrderString.toString(), multiplyQuestionOrderString.toString(), examSettingId);
        examQuestionOrderMapper.insert(examQuestionOrderEntity);

        //生成试题数据
        Integer id = examQuestionOrderEntity.getId();
        Integer pointPerSingleOption = entity.getPointPerSingleOption();
        Integer pointPerMultiplyOption = entity.getPointPerMultiplyOption();

        return new PaperVO(id, subject, startTime, endTime, pointPerSingleOption,
                pointPerMultiplyOption, singleQuestionList, multiplyQuestionList);
    }

    @Override
    public void saveStudentExam(Integer paperId, List<String> singleOptionAnswers, List<String> multiplyOptionAnswers) {
        ExamResultEntity examResultEntity = new ExamResultEntity();

        ExamQuestionOrderEntity questionOrderEntity = examQuestionOrderMapper.findById(paperId);
        String email = questionOrderEntity.getEmail();
        Integer examSettingId = questionOrderEntity.getExamSettingId();
        UserEntity userEntity = userMapper.findByEmail(email);
        ExamSettingEntity examSettingEntity = examSettingMapper.findById(examSettingId);
        String subject = examSettingEntity.getSubject();

        //单选题-学生答案改为map存储
        List<SingleOptionEntity> singleOptionList = singleOptionMapper.getBySubject(subject);
        Map<Integer, SingleOptionEntity> singleOptionMap = new HashMap<>(singleOptionList.size());
        for(SingleOptionEntity entity: singleOptionList){
            singleOptionMap.put(entity.getId(), entity);
        }

        //单选题-学生答案
        StringBuilder singleOptionStudentAnswer = new StringBuilder();
        for(int i=0;i<singleOptionAnswers.size();i++){
            if( i == 0){
                singleOptionStudentAnswer.append(singleOptionAnswers.get(i));
            }else {
                singleOptionStudentAnswer.append("-"+singleOptionAnswers.get(i));
            }
        }

        //单选题-试题顺序
        String singleOptionOrder = questionOrderEntity.getSingleOptionOrder();

        //单选题-正确答案
        StringBuilder singleOptionCorrectAnswer = new StringBuilder();
        int correctSingleNum = 0;
        String[] singleOptionOrderSplit = singleOptionOrder.split("-");
        if(!StringUtils.isEmpty(singleOptionOrderSplit[0])){
            for(int i=0;i<singleOptionOrderSplit.length;i++){
                String str = singleOptionOrderSplit[i];
                Integer questionId = Integer.parseInt(str);
                SingleOptionEntity entity = singleOptionMap.get(questionId);
                String correctAnswer = entity.getAnswer();

                if(correctAnswer.equals(singleOptionAnswers.get(i))){
                    correctSingleNum ++;
                }

                if(i==0){
                    singleOptionCorrectAnswer.append(correctAnswer);
                }else {
                    singleOptionCorrectAnswer.append("-"+correctAnswer);
                }
            }
        }


        //多选题-学生答案改为map存储
        List<MultiplyOptionEntity> multiplyOptionList = multiplyOptionMapper.getBySubject(subject);
        Map<Integer, MultiplyOptionEntity> multiplyOptionMap = new HashMap<>(multiplyOptionList.size());
        for(MultiplyOptionEntity entity: multiplyOptionList){
            multiplyOptionMap.put(entity.getId(), entity);
        }

        //多选题-学生答案
        StringBuilder multiplyOptionStudentAnswer = new StringBuilder();
        for(int i=0;i<multiplyOptionAnswers.size();i++){
            if( i == 0){
                multiplyOptionStudentAnswer.append(multiplyOptionAnswers.get(i));
            }else {
                multiplyOptionStudentAnswer.append("-"+multiplyOptionAnswers.get(i));
            }
        }

        //多选题-试题顺序
        String multiplyOptionOrder = questionOrderEntity.getMultiplyOptionOrder();

        //多选题-正确答案
        StringBuilder multiplyOptionCorrectAnswer = new StringBuilder();
        int correctMultiplyNum = 0;
        String[] multiplyOptionOrderSplit = multiplyOptionOrder.split("-");
        if(!StringUtils.isEmpty(multiplyOptionOrderSplit[0])){
            for(int i=0;i<multiplyOptionOrderSplit.length;i++){
                String str = multiplyOptionOrderSplit[i];
                Integer questionId = Integer.parseInt(str);
                MultiplyOptionEntity entity = multiplyOptionMap.get(questionId);
                String correctAnswer = entity.getAnswer();

                if(correctAnswer.equals(multiplyOptionAnswers.get(i))){
                    correctMultiplyNum ++;
                }

                if(i==0){
                    multiplyOptionCorrectAnswer.append(correctAnswer);
                }else {
                    multiplyOptionCorrectAnswer.append("-"+correctAnswer);
                }
            }
        }


        //题型分值
        int pointPerSingleOptionQuestion = examSettingEntity.getPointPerSingleOption();
        int pointPerMultiplyOptionQuestion = examSettingEntity.getPointPerMultiplyOption();

        //题型个数
        int singleOptionQuestionNum = singleOptionOrderSplit.length;
        int multiplyOptionQuestionNum = multiplyOptionOrderSplit.length;

        //得分情况
        int sumPoint = pointPerSingleOptionQuestion * singleOptionQuestionNum + pointPerMultiplyOptionQuestion * multiplyOptionQuestionNum;
        int studentPoint = pointPerSingleOptionQuestion * correctSingleNum + pointPerMultiplyOptionQuestion * correctMultiplyNum;

        examResultEntity.setStudentId(userEntity.getStudentId());
        examResultEntity.setStudentName(userEntity.getName());
        examResultEntity.setSubject(subject);
        examResultEntity.setSingleOptionQuestion(singleOptionOrder);
        examResultEntity.setSingleOptionStudentAnswer(singleOptionStudentAnswer.toString());
        examResultEntity.setSingleOptionCorrectAnswer(singleOptionCorrectAnswer.toString());
        examResultEntity.setMultiplyOptionQuestion(multiplyOptionOrder);
        examResultEntity.setMultiplyOptionStudentAnswer(multiplyOptionStudentAnswer.toString());
        examResultEntity.setMultiplyOptionCorrectAnswer(multiplyOptionCorrectAnswer.toString());
        examResultEntity.setPointPerSingleOptionQuestion(pointPerSingleOptionQuestion);
        examResultEntity.setPointPerMultiplyOptionQuestion(pointPerMultiplyOptionQuestion);
        examResultEntity.setSumPoint(sumPoint);
        examResultEntity.setStudentPoint(studentPoint);
        examResultEntity.setEmail(email);

        examResultMapper.insert(examResultEntity);

        mailService.sendExamResult(email, subject, sumPoint, studentPoint);
    }

    private List<String> getStudentEmailList(XSSFWorkbook workbook){
        List<String> emailList = new ArrayList<>();

        XSSFSheet xssfSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = xssfSheet.rowIterator();
        while (iterator.hasNext()){
            Row currentRow = iterator.next();
            String firstContent = currentRow.getCell(0).getStringCellValue();
            String secondContent = currentRow.getCell(1).getStringCellValue();

            if(!"考生姓名".equals(firstContent) &&
                    !StringUtils.isEmpty(secondContent)){
                emailList.add(secondContent);
            }

        }

        return emailList;
    }
}
