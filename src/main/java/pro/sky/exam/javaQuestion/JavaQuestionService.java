package pro.sky.exam.javaQuestion;

import org.springframework.stereotype.Service;
import pro.sky.exam.Question;

import java.util.*;

@Service

public class JavaQuestionService implements QuestionService {
    private Set<Question> questions = new HashSet<>();

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
    }

    public JavaQuestionService() {

    }

    @Override
    public Question add(String question, String answer) {
        Question questionNew = new Question(question, answer);
        questions.add(questionNew);
        return questionNew;
    }

    @Override
    public Question add(Question question) {
        if (question == null){
            throw new NullPointerException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (question == null){
            throw new NullPointerException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionsList = new ArrayList<>(questions);
        Random randomQuestion = new Random();
        int i = randomQuestion.nextInt(questions.size());
        return questionsList.get(i);
    }
}
