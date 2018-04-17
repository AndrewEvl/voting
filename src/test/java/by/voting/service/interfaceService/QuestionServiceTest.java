package by.voting.service.interfaceService;

import by.voting.config.RepositoryConfigurationTest;
import by.voting.entity.Question;
import by.voting.entity.Variant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfigurationTest.class})
public class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private VariantService variantService;

    @Test
    public void save() {
        Variant variant = new Variant();
        Question question = new Question();
        variant.setVariant("test");
        variant.setPeopleLike(25L);
        question.setQuestion("test");
        List<Variant> variants = new ArrayList<>();
        variants.add(variant);
        variantService.save(variant);
        question.setVariant(variants);
        questionService.save(question);
        System.out.println(question);
        Variant voteFindById = variantService.findById(variant.getId()).get();
        assertEquals(voteFindById.getVariant(), question.getVariant());
    }
}