package by.voting.controller;


import by.voting.service.interfaceService.VoteService;
import by.voting.service.interfaceService.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VotingController {

    private VoteService voteService;
    private VotingService votingService;

    @Autowired
    public VotingController(VoteService voteService, VotingService votingService) {
        this.voteService = voteService;
        this.votingService = votingService;
    }

    @GetMapping("/")
    public String homePageGet (){
        return "homePage";
    }
}
