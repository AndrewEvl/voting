package by.voting.service.interfaceService;

import by.voting.config.RepositoryConfigurationTest;
import by.voting.entity.Question;
import by.voting.entity.Status;
import by.voting.entity.Variant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfigurationTest.class})
public class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private VariantService variantService;

    @Test
    public void saveAndFindByIdAndDelete() {
        Question question = new Question();
        Variant variant = new Variant();

        variant.setVariant("test variant");
        variant.setPeopleLike(5L);

        question.setQuestion("test");
        List<Variant> variantList = new ArrayList<>();
        variantList.add(variant);
        question.setVariant(variantList);
        question.setStatus(Status.OPEN);
        questionService.save(question);
        variant.setQuestion(question);
        variantService.save(variant);

        Optional<Question> byId = questionService.findById(question.getId());
        byId
                .ifPresent(question1 -> assertEquals(question1.getQuestion(), question.getQuestion()));
        variantService.delete(variant.getId());
        questionService.delete(question.getId());

    }
}