package pro.sky.exam.javaQuestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.sky.exam.question.Question;
import pro.sky.exam.question.QuestionRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private Set<Question> questions = new HashSet<>();
    public JavaQuestionRepository(Set<Question> questions) {
        this.questions = questions;
    }

    public JavaQuestionRepository() {

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
        return null;
    }

    @Override
    public void init() {

    }
}
