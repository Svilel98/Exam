package pro.sky.exam.question;

import pro.sky.exam.question.Question;

import java.util.Collection;

public interface QuestionService {
    public Question add(String question, String answer);
    public Question getRandomQuestion();
    public Integer getQuestionsSize();
}
