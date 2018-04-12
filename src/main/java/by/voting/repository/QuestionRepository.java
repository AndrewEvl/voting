package by.voting.repository;

import by.voting.entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Override
    <S extends Question> S save(S s);

    @Override
    <S extends Question> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<Question> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<Question> findAll();

    @Override
    Iterable<Question> findAllById(Iterable<Long> iterable);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Question question);
}
