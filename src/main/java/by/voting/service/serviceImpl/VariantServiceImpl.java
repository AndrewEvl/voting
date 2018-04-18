package by.voting.service.serviceImpl;

import by.voting.entity.Variant;
import by.voting.repository.VariantRepository;
import by.voting.service.interfaceService.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class VariantServiceImpl implements VariantService {

    private VariantRepository variantRepository;

    @Autowired
    public VariantServiceImpl(VariantRepository variantRepository) {
        this.variantRepository = variantRepository;
    }

    @Override
    public void save(Variant variant) {
        variantRepository.save(variant);
    }

    @Override
    public Optional<Variant> findById(Long id) {
        return variantRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        variantRepository.deleteById(id);
    }

    @Override
    public void saveAll(List<Variant> variantList) {
        variantRepository.saveAll(variantList);
    }
}
