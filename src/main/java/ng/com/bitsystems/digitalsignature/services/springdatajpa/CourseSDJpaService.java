package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.command.CoursesCommand;
import ng.com.bitsystems.digitalsignature.converters.CoursesCommandToCourses;
import ng.com.bitsystems.digitalsignature.converters.CoursesToCoursesCommand;
import ng.com.bitsystems.digitalsignature.model.Courses;
import ng.com.bitsystems.digitalsignature.repository.CoursesRepository;
import ng.com.bitsystems.digitalsignature.services.CoursesServices;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CourseSDJpaService implements CoursesServices {
    private CoursesRepository coursesRepository;
    private CoursesToCoursesCommand coursesToCoursesCommand;
    private CoursesCommandToCourses coursesCommandToCourses;

    public CourseSDJpaService(CoursesRepository coursesRepository, CoursesToCoursesCommand coursesToCoursesCommand, CoursesCommandToCourses coursesCommandToCourses) {
        this.coursesRepository = coursesRepository;
        this.coursesToCoursesCommand = coursesToCoursesCommand;
        this.coursesCommandToCourses = coursesCommandToCourses;
    }

    @Override
    public Set<Courses> findAll() {
        Set<Courses> courses = new HashSet<>();
        coursesRepository.findAll().forEach(courses::add);
        return courses;
    }

    @Override
    public Courses findByID(Long aLong) {
        return coursesRepository.findById(aLong).get();
    }

    @Override
    public Courses add(Courses object) {
        return coursesRepository.save(object);
    }

    @Override
    public void delete(Courses object) {
        coursesRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        coursesRepository.deleteById(aLong);
    }

    @Override
    public CoursesCommand getCourseCommandById(Long id) {
        return coursesToCoursesCommand.convert(findByID(id));
    }
}
