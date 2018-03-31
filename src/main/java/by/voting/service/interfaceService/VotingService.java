package by.voting.service.interfaceService;

import by.voting.entity.Voting;

import java.util.Optional;

public interface VotingService {

    void save(Voting voting);

    Iterable<Voting> findAll();

    Optional<Voting> findById(Long id);

    void delete(Voting voting);
}
