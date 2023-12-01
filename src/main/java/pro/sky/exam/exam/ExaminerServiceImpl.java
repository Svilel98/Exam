package pro.sky.exam.exam;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.exam.question.Question;
import pro.sky.exam.exception.ExceptionNumberOfQuestionsExceeded;
import pro.sky.exam.question.QuestionRepository;
import pro.sky.exam.question.QuestionService;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws ExceptionNumberOfQuestionsExceeded {
        if (amount > questionService.getQuestionsSize()) {
            throw new ExceptionNumberOfQuestionsExceeded("Превышено количество допустимых вопросов");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Укажите корректные данные");
        }
        Collection<Question> collectionQuestion = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            Question randomQuestion = questionService.getRandomQuestion();
            while(collectionQuestion.contains(randomQuestion)) {
                randomQuestion = questionService.getRandomQuestion();
            }
            collectionQuestion.add(randomQuestion);
        }
        return collectionQuestion;
    }
}
