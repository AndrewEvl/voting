package by.voting.controller;


import by.voting.dto.AllSaveDto;
import by.voting.entity.Question;
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
import java.util.Set;

@Controller
public class VotingController {

    private QuestionService questionService;
    private VariantService variantService;
    private static Long ID;

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
    public String homePagePost(AllSaveDto allSaveDto) {
        Question question = new Question();
        question.setQuestion(allSaveDto.getQuestionName());
        ArrayList<Variant> variantsList = new ArrayList<>();
        question.setQuestion(allSaveDto.getQuestionName());
        questionService.save(question);
        for (int i = 0; i < allSaveDto.getVariantsName().size() ; i++) {
            Variant variantAtList = new Variant();
            List<String> variantsName = allSaveDto.getVariantsName();
            String nameVariant = variantsName.get(i);
            variantAtList.setVariant(nameVariant);
            variantAtList.setQuestion(question);
            variantsList.add(variantAtList);
        }
        variantService.saveAll(variantsList);
        question.setVariant(variantsList);
        questionService.save(question);
        return "redirect:/info";
    }

    @GetMapping("/info")
    public String infoGet (){
        return "info-page";
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public String questionInfoGet (@PathVariable("id") Long id, Model model){
        Question byId = questionService.findById(id).get();
        List<Variant> variants = byId.getVariant();
        model.addAttribute("variants",variants);
        model.addAttribute("byId", byId);
        return "info-page";
    }

    @GetMapping("/add-like")
    public String addLikeGet (){
        return "add-like";
    }

    @RequestMapping(value = "/add-likes/{id}", method = RequestMethod.POST)
    public String addLikePost(@PathVariable("id") Long id){
        return "";
    }



}
