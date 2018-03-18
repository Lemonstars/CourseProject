package cn.edu.nju.software.onlineexamsystem.form;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/10
 */
public class PaperForm {

    private Integer paperId;
    private List<String> singleOptionQuestionAnswers;
    private List<String> multiplyOptionQuestionAnswers;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public List<String> getSingleOptionQuestionAnswers() {
        return singleOptionQuestionAnswers;
    }

    public void setSingleOptionQuestionAnswers(List<String> singleOptionQuestionAnswers) {
        this.singleOptionQuestionAnswers = singleOptionQuestionAnswers;
    }

    public List<String> getMultiplyOptionQuestionAnswers() {
        return multiplyOptionQuestionAnswers;
    }

    public void setMultiplyOptionQuestionAnswers(List<String> multiplyOptionQuestionAnswers) {
        this.multiplyOptionQuestionAnswers = multiplyOptionQuestionAnswers;
    }

    @Override
    public String toString() {
        return "PaperForm{" +
                "paperId=" + paperId +
                ", singleOptionQuestionAnswers=" + singleOptionQuestionAnswers +
                ", multiplyOptionQuestionAnswers=" + multiplyOptionQuestionAnswers +
                '}';
    }
}
