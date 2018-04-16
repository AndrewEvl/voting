package by.voting.repository;

import by.voting.entity.Variant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface VariantRepository extends CrudRepository<Variant, Long> {

    @Override
    <S extends Variant> S save(S s);

    @Override
    <S extends Variant> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<Variant> findById(Long aLong);

    @Override
    Iterable<Variant> findAll();

    @Override
    Iterable<Variant> findAllById(Iterable<Long> iterable);

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Variant variant);

    Optional<Variant> findByVariantAndQuestion_Id (String variant, Long id);
}
