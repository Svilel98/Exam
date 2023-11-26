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
import pro.sky.exam.javaQuestion.QuestionService;
import java.util.Collection;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class TestMock {
    private Question question = new Question("2+2", "= 4");
    private final int amount = 1;
    private final int negativeAmount = -5;
    @Mock
    private QuestionService javaQuestionService;
    private ExaminerServiceImpl out;

    @BeforeEach
    public void BeforeEach() {
        out = new ExaminerServiceImpl(javaQuestionService);
    }


    @Test
    void ExceptionNumberOfQuestionsExceeded() {
        assertNotNull(javaQuestionService);
        Mockito.when(javaQuestionService.getAll()).thenReturn(Set.of(question));
        Assertions.assertThrows(ExceptionNumberOfQuestionsExceeded.class, () -> out.getQuestions(amount + 1));
    }

    @Test
    void IllegalArgumentException() {
        Mockito.when(javaQuestionService.getAll()).thenReturn(Set.of(question));
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.getQuestions(negativeAmount));
    }

    @Test
    void methodWasExecutedOneTimes() {
        Mockito.when(javaQuestionService.getAll()).thenReturn(Set.of(question));
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(question);
        out.getQuestions(1);
        Mockito.verify(javaQuestionService, Mockito.times(1)).getRandomQuestion();
    }

    @Test
    void correctedTest() {
        Mockito.when(javaQuestionService.getAll()).thenReturn(Set.of(question));
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(question);
        Collection<Question> actual = out.getQuestions(amount);
        Assertions.assertIterableEquals(Set.of(question), actual);
    }
}
