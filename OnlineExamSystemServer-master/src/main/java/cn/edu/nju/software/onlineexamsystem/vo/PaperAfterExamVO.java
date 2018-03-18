package cn.edu.nju.software.onlineexamsystem.vo;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/11
 */
public class PaperAfterExamVO {

    private String subject;
    private List<OptionQuestionAnswerVO> singleOptionList;
    private List<OptionQuestionAnswerVO> multiplyOptionList;

    public PaperAfterExamVO(String subject, List<OptionQuestionAnswerVO> singleOptionList, List<OptionQuestionAnswerVO> multiplyOptionList) {
        this.subject = subject;
        this.singleOptionList = singleOptionList;
        this.multiplyOptionList = multiplyOptionList;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<OptionQuestionAnswerVO> getSingleOptionList() {
        return singleOptionList;
    }

    public void setSingleOptionList(List<OptionQuestionAnswerVO> singleOptionList) {
        this.singleOptionList = singleOptionList;
    }

    public List<OptionQuestionAnswerVO> getMultiplyOptionList() {
        return multiplyOptionList;
    }

    public void setMultiplyOptionList(List<OptionQuestionAnswerVO> multiplyOptionList) {
        this.multiplyOptionList = multiplyOptionList;
    }

    @Override
    public String toString() {
        return "PaperAfterExamVO{" +
                "subject='" + subject + '\'' +
                ", singleOptionList=" + singleOptionList +
                ", multiplyOptionList=" + multiplyOptionList +
                '}';
    }
}
