package by.voting.service.interfaceService;

import by.voting.entity.Question;

import java.util.Optional;

public interface QuestionService {

    void save(Question question);

    Iterable<Question> findAll();

    Optional<Question> findById(Long id);

    void delete(Question question);

}
