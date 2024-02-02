package pro.sky.exam.javaQuestion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exam.question.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    private final JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionController(JavaQuestionService javaQuestionService, JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionService = javaQuestionService;
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @GetMapping(path = "/add", params = {"question", "answer"})
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) {
        Question fullQuestion = new Question(question, answer);
        javaQuestionRepository.remove(fullQuestion);
        return fullQuestion;
    }

    @GetMapping
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }
}
