package pro.sky.exam.exam;

import org.springframework.stereotype.Service;
import pro.sky.exam.Question;
import pro.sky.exam.exception.ExceptionNumberOfQuestionsExceeded;
import pro.sky.exam.javaQuestion.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws ExceptionNumberOfQuestionsExceeded {
        if (amount > questionService.getAll().size()){
            throw new ExceptionNumberOfQuestionsExceeded("Превышено количество допустимых вопросов");
        }
        if (amount <= 0){
            throw new IllegalArgumentException("Укажите корректные данные");
        }
        Collection<Question> collectionQuestion = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            collectionQuestion.add(questionService.getRandomQuestion());
        }
        return collectionQuestion;
    }
}
