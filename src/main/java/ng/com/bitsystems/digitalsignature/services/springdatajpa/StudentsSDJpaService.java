package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.model.Students;
import ng.com.bitsystems.digitalsignature.repository.StudentsRepository;
import ng.com.bitsystems.digitalsignature.services.StudentsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentsSDJpaService implements StudentsService {
    private StudentsRepository studentsRepository;

    public StudentsSDJpaService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public Set<Students> findAll() {
        Set<Students> students = new HashSet<>();
        studentsRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public Students findByID(Long aLong) {
        return studentsRepository.findById(aLong).get();
    }

    @Override
    public Students add(Students object) {
        return studentsRepository.save(object);
    }

    @Override
    public void delete(Students object) {
        studentsRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        studentsRepository.deleteById(aLong);
    }
}
