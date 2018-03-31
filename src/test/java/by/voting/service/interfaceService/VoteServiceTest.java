package by.voting.service.interfaceService;

import by.voting.config.RepositoryConfigurationTest;
import by.voting.entity.Vote;
import by.voting.entity.Voting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfigurationTest.class})
public class VoteServiceTest {

    @Autowired
    private VoteService voteService;
    @Autowired
    private VotingService votingService;

    @Test
    public void save() {
        Vote vote = new Vote();
        Voting voting = new Voting();
        voting.setName("test");
        vote.setLike(25L);
        vote.setVariant("test");
        Set<Vote> votes = new HashSet<>();
        votes.add(vote);
        voteService.save(vote);
        voting.setVotes(votes);
        votingService.save(voting);
        System.out.println(voting);
        Vote voteFindById = voteService.findById(vote.getId()).get();
        assertEquals(voteFindById.getVariant(), vote.getVariant());
    }

    @Test
    public void findAll() {
    }

    @Test
    public void delete() {
    }
}