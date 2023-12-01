package pro.sky.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.exam.exam.ExaminerServiceImpl;
import pro.sky.exam.exception.ExceptionNumberOfQuestionsExceeded;
import pro.sky.exam.javaQuestion.JavaQuestionService;
import pro.sky.exam.mathQuestion.MathQuestionService;
import pro.sky.exam.question.QuestionRepository;
import pro.sky.exam.question.QuestionService;
import pro.sky.exam.question.Question;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class TestMock {
    private Question question = new Question("2+2", "= 4");
    private final int amount = 1;
    private final int negativeAmount = -5;
    private int size = 10;
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @Mock
    private QuestionRepository questionRepository;
    private ExaminerServiceImpl outJava;
    private ExaminerServiceImpl outMath;

    @BeforeEach
    public void BeforeEach() {
        outJava = new ExaminerServiceImpl(javaQuestionService);
        outMath = new ExaminerServiceImpl(mathQuestionService);
    }


    @Test
    void ExceptionNumberOfQuestionsExceeded() {
        assertNotNull(mathQuestionService);
        Assertions.assertThrows(ExceptionNumberOfQuestionsExceeded.class, () -> outMath.getQuestions(mathQuestionService.getQuestionsSize()+1));
    }

    @Test
    void IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> outJava.getQuestions(negativeAmount));
    }

    @Test
    void methodWasExecutedOneTimes() {
        Mockito.when(mathQuestionService.getRandomQuestion()).thenReturn(question);
        Mockito.when(mathQuestionService.getQuestionsSize()).thenReturn(size);
        outMath.getQuestions(1);
        Mockito.verify(mathQuestionService, Mockito.times(1)).getRandomQuestion();
    }

    @Test
    void correctedTest() {
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(question);
        Mockito.when(javaQuestionService.getQuestionsSize()).thenReturn(size);
        Collection<Question> actual = outJava.getQuestions(amount);
        Assertions.assertIterableEquals(Set.of(question), actual);
    }

    @Test
    void ExceptionNumberOfQuestionsExceededMath() {
        assertNotNull(javaQuestionService);
        Assertions.assertThrows(ExceptionNumberOfQuestionsExceeded.class, () -> outMath.getQuestions(amount + 1));
    }

    @Test
    void IllegalArgumentExceptionMath() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> outMath.getQuestions(negativeAmount));
    }

    @Test
    void methodWasExecutedOneTimesMath() {
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(question);
        Mockito.when(javaQuestionService.getQuestionsSize()).thenReturn(size);
        outJava.getQuestions(1);
        Mockito.verify(javaQuestionService, Mockito.times(1)).getRandomQuestion();
    }

    @Test
    void correctedTestMath() {
        Mockito.when(mathQuestionService.getRandomQuestion()).thenReturn(question);
        Mockito.when(mathQuestionService.getQuestionsSize()).thenReturn(size);
        Collection<Question> actual = outMath.getQuestions(amount);
        Assertions.assertIterableEquals(Set.of(question), actual);
    }
}
