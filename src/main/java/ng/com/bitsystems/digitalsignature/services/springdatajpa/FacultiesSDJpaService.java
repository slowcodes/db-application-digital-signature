package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.model.Faculties;
import ng.com.bitsystems.digitalsignature.repository.FacultiesRepository;
import ng.com.bitsystems.digitalsignature.services.FacultiesService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FacultiesSDJpaService implements FacultiesService {
    
    private FacultiesRepository facultiesRepository;

    public FacultiesSDJpaService(FacultiesRepository facultiesRepository) {
        this.facultiesRepository = facultiesRepository;
    }

    @Override
    public Set<Faculties> findAll() {
        Set<Faculties> faculties = new HashSet<>();
        facultiesRepository.findAll().forEach(faculties::add);
        return faculties;
    }

    @Override
    public Faculties findByID(Long aLong) {
        return facultiesRepository.findById(aLong).get();
    }

    @Override
    public Faculties add(Faculties object) {
        return facultiesRepository.save(object);
    }

    @Override
    public void delete(Faculties object) {
        facultiesRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        facultiesRepository.deleteById(aLong);
    }
}
