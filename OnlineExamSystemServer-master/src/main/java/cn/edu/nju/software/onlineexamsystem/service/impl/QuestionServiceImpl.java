package cn.edu.nju.software.onlineexamsystem.service.impl;

import cn.edu.nju.software.onlineexamsystem.mapper.MultiplyOptionMapper;
import cn.edu.nju.software.onlineexamsystem.mapper.SingleOptionMapper;
import cn.edu.nju.software.onlineexamsystem.service.QuestionService;
import cn.edu.nju.software.onlineexamsystem.vo.SubjectVO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/11/16
 */
@Service
public class QuestionServiceImpl implements QuestionService{

    private static final int SINGLE_OPTION = 0;
    private static final int MULTIPLY_OPTION = 1;

    @Autowired
    private SingleOptionMapper singleOptionMapper;

    @Autowired
    private MultiplyOptionMapper multiplyOptionMapper;

    @Override
    public XSSFWorkbook createSingleOptionWorkBook(){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();

        XSSFRow firstRow = sheet.createRow(0);
        XSSFCell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("请按照如下格式导入试题（请删除所有示例后填写；同类型的题目在一起；题型有单选、多选；不同题型间用空行隔开)");

        XSSFRow singleOptionRow = sheet.createRow(1);
        singleOptionRow.createCell(0).setCellValue("题型");
        singleOptionRow.createCell(1).setCellValue("单选题");

        XSSFRow singleOptionTitleRow = sheet.createRow(2);
        singleOptionTitleRow.createCell(0).setCellValue("问题");
        singleOptionTitleRow.createCell(1).setCellValue("选项A");
        singleOptionTitleRow.createCell(2).setCellValue("选项B");
        singleOptionTitleRow.createCell(3).setCellValue("选项C");
        singleOptionTitleRow.createCell(4).setCellValue("选项D");
        singleOptionTitleRow.createCell(5).setCellValue("答案(请填写A或B或C或D)");

        int singleOptionContentStartPos = 3;
        int singleOptionContentEndPos = 6;
        for(int i=singleOptionContentStartPos;i<singleOptionContentEndPos;i++){
            XSSFRow singleOptionContentRow = sheet.createRow(i);
            singleOptionContentRow.createCell(0).setCellValue("示例：OS是什么的简写");
            singleOptionContentRow.createCell(1).setCellValue("操作系统");
            singleOptionContentRow.createCell(2).setCellValue("编译原理");
            singleOptionContentRow.createCell(3).setCellValue("数据库");
            singleOptionContentRow.createCell(4).setCellValue("计算机网络");
            singleOptionContentRow.createCell(5).setCellValue("A");
        }

        XSSFRow multiplyOptionRow = sheet.createRow(7);
        multiplyOptionRow.createCell(0).setCellValue("题型");
        multiplyOptionRow.createCell(1).setCellValue("多选题");

        XSSFRow multiplyOptionTitleRow = sheet.createRow(8);
        multiplyOptionTitleRow.createCell(0).setCellValue("问题");
        multiplyOptionTitleRow.createCell(1).setCellValue("选项A");
        multiplyOptionTitleRow.createCell(2).setCellValue("选项B");
        multiplyOptionTitleRow.createCell(3).setCellValue("选项C");
        multiplyOptionTitleRow.createCell(4).setCellValue("选项D");
        multiplyOptionTitleRow.createCell(5).setCellValue("答案(ABCD间用&符号隔开)");

        int multiplyOptionContentStartPos = 9;
        int multiplyOptionContentEndPos = 12;
        for(int i=multiplyOptionContentStartPos;i<multiplyOptionContentEndPos;i++){
            XSSFRow multiplyOptionContentRow = sheet.createRow(i);
            multiplyOptionContentRow.createCell(0).setCellValue("示例：以下是冯诺伊曼体系组成部分的有");
            multiplyOptionContentRow.createCell(1).setCellValue("内存");
            multiplyOptionContentRow.createCell(2).setCellValue("磁盘");
            multiplyOptionContentRow.createCell(3).setCellValue("输入");
            multiplyOptionContentRow.createCell(4).setCellValue("输出");
            multiplyOptionContentRow.createCell(5).setCellValue("A&C&D");
        }

        return workbook;
    }

    @Override
    public boolean uploadFile(String subject, MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
                this.extractQuestion(subject, workbook);

                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        return false;
    }

    @Override
    public List<String> getAllSubject() {
        List<String> result = new ArrayList<>();
        List<String> singleOptionSubject = singleOptionMapper.getAllSubject();
        List<String> multiplyOptionSubject = multiplyOptionMapper.getAllSubject();

        Set<String> set = new HashSet<>();
        set.addAll(singleOptionSubject);
        set.addAll(multiplyOptionSubject);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            result.add(iterator.next());
        }

        return result;
    }

    @Override
    public SubjectVO getSubjectQuestionCount(String subjectName) {
        int singleCount = singleOptionMapper.getSubjectQuestionCount(subjectName);
        int multiplyCount = multiplyOptionMapper.getSubjectQuestionCount(subjectName);
        SubjectVO subjectVO = new SubjectVO(subjectName, singleCount, multiplyCount);

        return subjectVO;
    }

    /**
     * 解析上传试题
     * @param subject
     * @param sheets
     */
    private void extractQuestion(String subject, XSSFWorkbook sheets) {
        XSSFSheet xssfSheet = sheets.getSheetAt(0);
        int currentQuestionType = -1;

        Iterator<Row> rowIterator = xssfSheet.rowIterator();
        while (rowIterator.hasNext()){
            Row currentRow = rowIterator.next();
            Cell firstCell = currentRow.getCell(0);
            String firstContent = firstCell.getStringCellValue();

            if("题型".equals(firstContent)){
                Cell secondCell = currentRow.getCell(1);
                String secondContent = secondCell.getStringCellValue();
                if("单选题".equals(secondContent)){
                    currentQuestionType = SINGLE_OPTION;
                }else if("多选题".equals(secondContent)){
                    currentQuestionType = MULTIPLY_OPTION;
                }
            }else if("问题".equals(firstContent) ||
                    StringUtils.isEmpty(firstContent)){
                continue;
            }else if(currentQuestionType == SINGLE_OPTION ||
                    currentQuestionType == MULTIPLY_OPTION){
                String question = firstContent;
                String option1 = currentRow.getCell(1).getStringCellValue();
                String option2 = currentRow.getCell(2).getStringCellValue();
                String option3 = currentRow.getCell(3).getStringCellValue();
                String option4 = currentRow.getCell(4).getStringCellValue();
                String answer = currentRow.getCell(5).getStringCellValue();

                if(currentQuestionType == SINGLE_OPTION){
                    singleOptionMapper.insertSingleOption(question, option1, option2, option3, option4, answer, subject);
                }else if(currentQuestionType == MULTIPLY_OPTION) {
                    multiplyOptionMapper.insertMultiplyOption(question, option1, option2, option3, option4, answer, subject);
                }
            }


        }

    }


}
