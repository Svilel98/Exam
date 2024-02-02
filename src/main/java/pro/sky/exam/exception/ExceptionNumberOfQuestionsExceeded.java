package pro.sky.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionNumberOfQuestionsExceeded extends RuntimeException {
    public ExceptionNumberOfQuestionsExceeded(String message) {
        super(message);
    }
}
