package by.voting.repository;

import by.voting.entity.Voting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface VotingRepository extends CrudRepository<Voting, Long> {

    @Override
    <S extends Voting> S save(S s);

    @Override
    <S extends Voting> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<Voting> findById(Long aLong);

    @Override
    Iterable<Voting> findAll();

    @Override
    Iterable<Voting> findAllById(Iterable<Long> iterable);

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Voting voting);
}
