package pro.sky.exam.mathQuestion;

import org.springframework.stereotype.Repository;
import pro.sky.exam.question.Question;
import pro.sky.exam.question.QuestionRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
public class MathQuestionRepository implements QuestionRepository {
    private Set<Question> questions = new HashSet<>();

    public MathQuestionRepository(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new NullPointerException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (question == null) {
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
    public void init() {

    }
}
