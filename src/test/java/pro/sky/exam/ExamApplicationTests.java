package pro.sky.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.exam.javaQuestion.JavaQuestionRepository;
import pro.sky.exam.javaQuestion.JavaQuestionService;
import pro.sky.exam.mathQuestion.MathQuestionRepository;
import pro.sky.exam.mathQuestion.MathQuestionService;
import pro.sky.exam.question.Question;

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
    JavaQuestionRepository outRepository = new JavaQuestionRepository();
    MathQuestionService mathQuestionService = new MathQuestionService();
    MathQuestionRepository mathQuestionRepository = new MathQuestionRepository();

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
        Question actual = outRepository.add(first);
        assertEquals(actual, first);
    }

    @Test
    void addNull() {
        Assertions.assertThrows(NullPointerException.class, () -> outRepository.add(questionNull));
    }

    @Test
    void removeFromSet() {
        mathQuestionRepository.add(first);
        mathQuestionRepository.add(second);
        mathQuestionRepository.remove(second);
        Set<Question> expected = new HashSet<>(Set.of(first));
        Collection actual = mathQuestionRepository.getAll();
        assertEquals(actual, expected);
    }

    @Test
    void remove() {
        outRepository.add(first);
        outRepository.add(second);
        Question expected = outRepository.remove(second);
        assertEquals(second, expected);
    }
    @Test
    void removeNull() {
        Assertions.assertThrows(NullPointerException.class, () -> outRepository.remove(questionNull));
    }

    @Test
    void getAll() {
        mathQuestionRepository.add(first);
        mathQuestionRepository.add(second);
        mathQuestionRepository.add(third);
        assertEquals(mathQuestionRepository.getAll().size(), 3);
        assertTrue(mathQuestionRepository.getAll().contains(first));
        assertTrue(mathQuestionRepository.getAll().contains(second));
        assertTrue(mathQuestionRepository.getAll().contains(third));
    }
}
