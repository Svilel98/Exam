package pro.sky.exam.mathQuestion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exam.question.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final MathQuestionService mathQuestionService;
    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionController(MathQuestionService mathQuestionService, MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionService = mathQuestionService;
        this.mathQuestionRepository = mathQuestionRepository;
    }
    @GetMapping(path = "/add", params = {"question", "answer"})
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) {
        Question fullQuestion = new Question(question, answer);
        mathQuestionRepository.remove(fullQuestion);
        return fullQuestion;
    }

    @GetMapping
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }
}
