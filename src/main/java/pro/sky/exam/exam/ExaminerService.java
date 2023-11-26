package pro.sky.exam.exam;

import pro.sky.exam.Question;

import java.util.Collection;

public interface ExaminerService {
    public Collection<Question> getQuestions(int amount);
}
