package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.model.Departments;
import ng.com.bitsystems.digitalsignature.repository.DepartmentRepository;
import ng.com.bitsystems.digitalsignature.services.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DepartmentSDJpaService implements DepartmentService{

    private DepartmentRepository departmentRepository;

    public DepartmentSDJpaService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Set<Departments> findAll(){
        Set<Departments> departments = new HashSet<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    @Override
    public Departments findByID(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Departments add(Departments departments) {
        return departmentRepository.save(departments);
    }

    @Override
    public void delete(Departments departments) {
        departmentRepository.delete(departments);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

}
