package by.voting.service.interfaceService;

import by.voting.entity.Vote;

import java.util.Optional;

public interface VoteService {

    void save(Vote vote);

    Iterable<Vote> findAll();

    Optional<Vote> findById(Long id);

    void delete(Vote vote);
}
