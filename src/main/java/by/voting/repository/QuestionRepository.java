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
    void deleteById(Long aLong);

    @Override
    <S extends Question> S save(S s);

    @Override
    Optional<Question> findById(Long aLong);
}
