package by.voting.controller;


import by.voting.dto.AllSaveDto;
import by.voting.entity.Question;
import by.voting.entity.Status;
import by.voting.entity.Variant;
import by.voting.service.interfaceService.QuestionService;
import by.voting.service.interfaceService.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class VotingController {

    private QuestionService questionService;
    private VariantService variantService;

    @Autowired
    public VotingController(QuestionService questionService, VariantService variantService) {
        this.questionService = questionService;
        this.variantService = variantService;
    }

    @ModelAttribute("question")
    public Question question() {
        return new Question();
    }

    @ModelAttribute("variant")
    public Variant variant() {
        return new Variant();
    }

    @ModelAttribute("allSaveDto")
    public AllSaveDto allSaveDto() {
        return new AllSaveDto();
    }

    @GetMapping("/")
    public String homePageGet() {
        return "homePage";
    }

    @PostMapping("/")
    public String homePagePost(AllSaveDto allSaveDto, Model model) {
        Question question = new Question();
        question.setQuestion(allSaveDto.getQuestionName());
        ArrayList<Variant> variantsList = new ArrayList<>();
        question.setQuestion(allSaveDto.getQuestionName());
        question.setStatus(Status.OPEN);
        questionService.save(question);
        for (int i = 0; i < allSaveDto.getVariantsName().size(); i++) {
            Variant variantAtList = new Variant();
            List<String> variantsName = allSaveDto.getVariantsName();
            String nameVariant = variantsName.get(i);
            variantAtList.setVariant(nameVariant);
            variantAtList.setQuestion(question);
            variantAtList.setPeopleLike(0L);
            variantsList.add(variantAtList);
        }
        variantService.saveAll(variantsList);
        question.setVariant(variantsList);
        questionService.save(question);
        if (question.getQuestion() != null
                && question.getVariant().size() > 0) {
            model.addAttribute("uniqueId", "Unique URL page for creator : http://localhost:8080/creator-info/" + question.getId());
            model.addAttribute("addLike", "URL for voting : http://localhost:8080/add-likes/" + question.getId());
            return "homePage";
        }
        return "homePage";
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public String questionInfoGet(@PathVariable("id") Long id, Model model) {
        Question byId = questionService.findById(id).get();
        List<Variant> variants = byId.getVariant();
        model.addAttribute("variants", variants);
        model.addAttribute("byId", byId);
        return "info-page";
    }

    @RequestMapping(value = "/creator-info/{id}", method = RequestMethod.GET)
    public String questionCreatorInfoGet(@PathVariable("id") Long id, Model model) {
        Question byId = questionService.findById(id).get();
        List<Variant> variants = byId.getVariant();
        model.addAttribute("variants", variants);
        model.addAttribute("byId", byId);
        model.addAttribute("urlLike", "URL for voting : http://localhost:8080/add-likes/" + byId.getId());
        model.addAttribute("urlInfo","URL info for other user : http://localhost:8080/info/" + byId.getId());
        return "creator-info-page";
    }

    @RequestMapping(value = "/add-likes/{id}", method = RequestMethod.GET)
    public String addLikeGet(@PathVariable("id") Long id, Model model) {
        Optional<Question> byId = questionService.findById(id);
        model.addAttribute("question", byId.get());
        Variant variantOne = byId.get().getVariant().get(0);
        Variant variantTwo = byId.get().getVariant().get(1);
        Variant variantTree = byId.get().getVariant().get(2);
        Variant variantFour = byId.get().getVariant().get(3);
        Variant variantFive = byId.get().getVariant().get(4);
        if (byId.get().getStatus() == Status.CLOSED) {
            model.addAttribute("closed", "This voting is closed!");
        }
        model.addAttribute("variantOne", variantOne);
        model.addAttribute("variantTwo", variantTwo);
        model.addAttribute("variantTree", variantTree);
        model.addAttribute("variantFour", variantFour);
        model.addAttribute("variantFive", variantFive);
        return "add-like-page";
    }

    @RequestMapping(value = "/add-like/add/{id}", method = RequestMethod.GET)
    public String addLikePost(@PathVariable("id") Long id) {
        Optional<Variant> byId = variantService.findById(id);
        if (byId.get().getQuestion().getStatus() != Status.CLOSED) {
            Long like = byId.get().getPeopleLike() + 1L;
            byId.get().setPeopleLike(like);
            variantService.save(byId.get());
            return "redirect:/";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/closed/{id}", method = RequestMethod.GET)
    public String closedIdGet(@PathVariable("id") Long id) {
        Optional<Question> byId = questionService.findById(id);
        byId.get().setStatus(Status.CLOSED);
        questionService.save(byId.get());
        return "redirect:/info/{id}";
    }
}
