package pro.sky.exam.javaQuestion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exam.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add", params = {"question","answer"})
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) {
        return javaQuestionService.add(question, answer);
    }
    @GetMapping(path = "/remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) {
        Question fullQuestion = new Question(question,answer);
        javaQuestionService.remove(fullQuestion);
        return fullQuestion;
    }
    @GetMapping
    public Collection<Question> getAll(){
     return javaQuestionService.getAll();
    }
}
