package by.voting.service.interfaceService;

import by.voting.entity.Variant;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface VariantService {

    void save(Variant variant);

    Iterable<Variant> findAll();

    Optional<Variant> findById(Long id);

    void delete(Variant variant);

    void saveAll (List<Variant> variantList);
}
