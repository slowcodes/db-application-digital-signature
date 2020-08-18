package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.model.States;
import ng.com.bitsystems.digitalsignature.repository.StatesRepository;
import ng.com.bitsystems.digitalsignature.services.StatesService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StatesSDJpaService implements StatesService {
    private StatesRepository statesRepository;

    public StatesSDJpaService(StatesRepository statesRepository) {
        this.statesRepository = statesRepository;
    }

    @Override
    public Set<States> findAll() {
        Set<States> states = new HashSet<>();
        statesRepository.findAll().forEach(states::add);
        return states;
    }

    @Override
    public States findByID(Long aLong) {
        return statesRepository.findById(aLong).get();
    }

    @Override
    public States add(States object) {
        return statesRepository.save(object);
    }

    @Override
    public void delete(States object) {
        statesRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        statesRepository.deleteById(aLong);
    }
}
