package pro.sky.exam.exam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exam.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/getQuestions")
    public Collection<Question> getQuestions(@RequestParam("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
