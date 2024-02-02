package pro.sky.exam.mathQuestion;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pro.sky.exam.javaQuestion.JavaQuestionRepository;
import pro.sky.exam.question.Question;
import pro.sky.exam.question.QuestionService;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {
    private MathQuestionRepository mathQuestionRepository;


    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    public MathQuestionService() {

    }


    @Override
    public Question add(String question, String answer) {
        Question questionNew = new Question(question, answer);
        mathQuestionRepository.add(questionNew);
        return questionNew;
    }
    @Override
    public Question getRandomQuestion() {
        List<Question> questionsList = new ArrayList<>(mathQuestionRepository.getAll());
        Random randomQuestion = new Random();
        int i = randomQuestion.nextInt(mathQuestionRepository.getAll().size());
        return questionsList.get(i);
    }
    @Override
    public Integer getQuestionsSize(){
        Integer size = mathQuestionRepository.getAll().size();
        return size;
    }
}
