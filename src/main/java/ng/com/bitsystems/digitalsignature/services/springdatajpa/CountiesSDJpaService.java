package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.model.Counties;
import ng.com.bitsystems.digitalsignature.repository.CountiesRepository;
import ng.com.bitsystems.digitalsignature.services.CountiesService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CountiesSDJpaService implements CountiesService {

    private CountiesRepository countiesRepository;
    public CountiesSDJpaService(CountiesRepository countiesRepository) {
        this.countiesRepository = countiesRepository;
    }

    @Override
    public Set<Counties> findAll() {
        Set<Counties> counties = new HashSet<>();
        countiesRepository.findAll().forEach(counties::add);
        return counties;
    }

    @Override
    public Counties findByID(Long aLong) {
        return countiesRepository.findById(aLong).get();
    }

    @Override
    public Counties add(Counties object) {
        return countiesRepository.save(object);
    }

    @Override
    public void delete(Counties object) {
        countiesRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        countiesRepository.deleteById(aLong);
    }
}
