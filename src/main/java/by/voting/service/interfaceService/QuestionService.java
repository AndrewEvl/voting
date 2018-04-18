package by.voting.service.interfaceService;

import by.voting.entity.Question;

import java.util.Optional;

public interface QuestionService {

    void save(Question question);

    Optional<Question> findById(Long id);

    void delete(Long id);

}
