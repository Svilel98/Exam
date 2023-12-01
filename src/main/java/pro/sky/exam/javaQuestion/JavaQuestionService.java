package pro.sky.exam.javaQuestion;

import org.springframework.stereotype.Service;
import pro.sky.exam.question.Question;
import pro.sky.exam.question.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    public JavaQuestionService() {

    }

    @Override
    public Question add(String question, String answer) {
        Question questionNew = new Question(question, answer);
        javaQuestionRepository.add(questionNew);
        return questionNew;
    }
    @Override
    public Integer getQuestionsSize(){
        int size = javaQuestionRepository.getAll().size();
        return size;
    }
    @Override
    public Question getRandomQuestion() {
        List<Question> questionsList = new ArrayList<>(javaQuestionRepository.getAll());
        Random randomQuestion = new Random();
        int i = randomQuestion.nextInt(questionsList.size());
        return questionsList.get(i);
    }
}
