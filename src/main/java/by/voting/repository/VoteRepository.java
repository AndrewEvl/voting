package by.voting.repository;

import by.voting.entity.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {

    @Override
    <S extends Vote> S save(S s);

    @Override
    <S extends Vote> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<Vote> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<Vote> findAll();

    @Override
    Iterable<Vote> findAllById(Iterable<Long> iterable);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Vote vote);
}
