package pro.sky.exam.mathQuestion;

import org.springframework.beans.factory.annotation.Qualifier;
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

    @Override
    public Question add(String question, String answer) {
        Question questionNew = new Question(question, answer);
        mathQuestionRepository.add(questionNew);
        return questionNew;
    }

//    @Override
//    public Question add(Question question) {
//        if (question == null) {
//            throw new NullPointerException();
//        }
//        questions.add(question);
//        return question;
//    }
//
//    @Override
//    public Question remove(Question question) {
//        if (question == null) {
//            throw new NullPointerException();
//        }
//        questions.remove(question);
//        return question;
//    }
//
//    @Override
//    public Collection<Question> getAll() {
//        return questions;
//    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionsList = new ArrayList<>(mathQuestionRepository.getAll());
        Random randomQuestion = new Random();
        int i = randomQuestion.nextInt(mathQuestionRepository.getAll().size());
        return questionsList.get(i);
    }
}
