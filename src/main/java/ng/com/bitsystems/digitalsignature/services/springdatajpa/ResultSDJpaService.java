package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.model.Results;
import ng.com.bitsystems.digitalsignature.repository.ResultsRepository;
import ng.com.bitsystems.digitalsignature.services.ResultsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ResultSDJpaService implements ResultsService {
    private ResultsRepository resultsRepository;

    public ResultSDJpaService(ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }

    @Override
    public Set<Results> findAll() {
        Set<Results> results = new HashSet<>();
        resultsRepository.findAll().forEach(results:: add);
        return results;
    }

    @Override
    public Results findByID(Long aLong) {
        return resultsRepository.findById(aLong).get();
    }

    @Override
    public Results add(Results object) {
        return resultsRepository.save(object);
    }

    @Override
    public void delete(Results object) {
        resultsRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        resultsRepository.deleteById(aLong);
    }
}
