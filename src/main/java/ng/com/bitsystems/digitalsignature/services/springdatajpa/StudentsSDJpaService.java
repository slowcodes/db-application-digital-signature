package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.command.StudentCommand;
import ng.com.bitsystems.digitalsignature.converters.StudentsCommandToStudents;
import ng.com.bitsystems.digitalsignature.converters.StudentsToStudentsCommand;
import ng.com.bitsystems.digitalsignature.model.Students;
import ng.com.bitsystems.digitalsignature.repository.StudentsRepository;
import ng.com.bitsystems.digitalsignature.services.StudentsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentsSDJpaService implements StudentsService {
    private StudentsRepository studentsRepository;
    private StudentsToStudentsCommand studentsToStudentsCommand;
    private StudentsCommandToStudents studentsCommandToStudents;

    public StudentsSDJpaService(StudentsRepository studentsRepository,
                                StudentsToStudentsCommand studentsToStudentsCommand,
                                StudentsCommandToStudents studentsCommandToStudents) {
        this.studentsRepository = studentsRepository;
        this.studentsToStudentsCommand = studentsToStudentsCommand;
        this.studentsCommandToStudents = studentsCommandToStudents;
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

    @Override
    public StudentCommand getCommandByMatricNumber(String matricNumber) {

        if(findByMatricNumber(matricNumber).size()>0){
            return studentsToStudentsCommand.convert(findByMatricNumber(matricNumber).get(0));
        }
        return null;
    }

    @Override
    public List<Students> findByMatricNumber(String matricNumber) {

        List<Students> students = new  ArrayList<>();
        studentsRepository.findAll().forEach(students1 -> {
            if(students1.getMatricNumber()==matricNumber)
                students.add(students1);
        });
        return students;
    }
}
