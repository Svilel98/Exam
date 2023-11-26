package pro.sky.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.exam.exam.ExaminerServiceImpl;
import pro.sky.exam.javaQuestion.JavaQuestionService;
import pro.sky.exam.javaQuestion.QuestionService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExamApplicationTests {
    private String firstQuestion;
    private String secondQuestion;
    private String thirdQuestion;
    private String fourthQuestion;
    private String fifthQuestion;
    private String nullQuestion;
    private String firstAnswer;
    private String secondAnswer;
    private String thirdAnswer;
    private String fourAnswer;
    private String fifthAnswer;
    private String nullAnswer;
    private Question first;
    private Question second;
    private Question third;
    private Question four;
    private Question fifth;
    private Question questionNull;
    JavaQuestionService out = new JavaQuestionService();

    @BeforeEach
    public void setup() {
        firstQuestion = "Сколько будет 2 + 2?";
        secondQuestion = "Сколько будет 4 + 4?";
        thirdQuestion = "Сколько будет 2 + 5?";
        fourthQuestion = "Сколько будет 2 + 3?";
        fifthQuestion = "Сколько будет 2 + 6?";
        nullQuestion = null;
        firstAnswer = "4";
        secondAnswer = "8";
        thirdAnswer = "7";
        fourAnswer = "5";
        fifthAnswer = "8";
        nullAnswer = null;
        first = new Question(firstQuestion, firstAnswer);
        second = new Question(secondQuestion, secondAnswer);
        third = new Question(thirdQuestion, thirdAnswer);
        four = new Question(fourthQuestion, fourAnswer);
        fifth = new Question(fifthQuestion, fifthAnswer);
        questionNull = null;
    }

    @Test
    void add() {
        Question actual = out.add(firstQuestion, firstAnswer);
        assertEquals(actual, first);
    }

    @Test
    void addNull() {
        Assertions.assertThrows(NullPointerException.class, () -> out.add(questionNull));
    }

    @Test
    void removeFromSet() {
        out.add(first);
        out.add(second);
        out.remove(second);
        Set<Question> expected = new HashSet<>(Set.of(first));
        Collection actual = out.getAll();
        assertEquals(actual, expected);
    }

    @Test
    void remove() {
        out.add(first);
        out.add(second);
        Question expected = out.remove(second);
        assertEquals(second, expected);
    }
    @Test
    void removeNull() {
        Assertions.assertThrows(NullPointerException.class, () -> out.remove(questionNull));
    }

    @Test
    void getAll() {
        out.add(first);
        out.add(second);
        out.add(third);
        assertEquals(out.getAll().size(), 3);
        assertTrue(out.getAll().contains(first));
        assertTrue(out.getAll().contains(second));
        assertTrue(out.getAll().contains(third));
    }
}
