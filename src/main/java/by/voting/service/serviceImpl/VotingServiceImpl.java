package by.voting.service.serviceImpl;

import by.voting.entity.Voting;
import by.voting.repository.VotingRepository;
import by.voting.service.interfaceService.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class VotingServiceImpl implements VotingService {

    private VotingRepository votingRepository;

    @Autowired
    public VotingServiceImpl(VotingRepository votingRepository) {
        this.votingRepository = votingRepository;
    }

    @Override
    public void save(Voting voting) {
        votingRepository.save(voting);
    }

    @Override
    public Iterable<Voting> findAll() {
        return votingRepository.findAll();
    }

    @Override
    public Optional<Voting> findById(Long id) {
        return votingRepository.findById(id);
    }

    @Override
    public void delete(Voting voting) {
        votingRepository.delete(voting);
    }
}
