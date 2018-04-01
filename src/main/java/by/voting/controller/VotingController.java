package by.voting.controller;


import by.voting.dto.AllSaveDto;
import by.voting.entity.Vote;
import by.voting.entity.Voting;
import by.voting.service.interfaceService.VoteService;
import by.voting.service.interfaceService.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VotingController {

    private VoteService voteService;
    private VotingService votingService;

    @Autowired
    public VotingController(VoteService voteService, VotingService votingService) {
        this.voteService = voteService;
        this.votingService = votingService;
    }

    @ModelAttribute("vote")
    public Vote vote() {
        return new Vote();
    }

    @ModelAttribute("voting")
    public Voting voting() {
        return new Voting();
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
    public String homePagePost(AllSaveDto allSaveDto, Vote vote, Voting voting, Model model) {
        voting.setName(allSaveDto.getVotingName());
        votingService.save(voting);
        model.addAttribute("id", voting.getId());
        return "redirect:/voting/{id}";
    }

    @GetMapping("/voting/{id}")
    public String votingAddGet(@PathVariable("id") Long id, Vote vote) {
        Voting votingById = votingService.findById(id).get();
        vote.setVoting(votingById);
        voteService.save(vote);
        return "redirect:/";
    }
}
