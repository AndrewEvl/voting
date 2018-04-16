package by.voting.service.interfaceService;

import by.voting.entity.Variant;

import java.util.List;
import java.util.Optional;

public interface VariantService {

    void save(Variant variant);

    Iterable<Variant> findAll();

    Optional<Variant> findById(Long id);

    void delete(Variant variant);

    void saveAll (List<Variant> variantList);

    Optional<Variant> findByVariantAndQuestion_Id (String variant, Long id);
}
