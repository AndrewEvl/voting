package by.voting.service.interfaceService;

import by.voting.entity.Variant;

import java.util.List;
import java.util.Optional;

public interface VariantService {

    void save(Variant variant);

    Optional<Variant> findById(Long id);

    void delete(Long id);

    void saveAll(List<Variant> variantList);
}
