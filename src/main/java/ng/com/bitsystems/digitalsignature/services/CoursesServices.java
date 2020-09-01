package ng.com.bitsystems.digitalsignature.services;

import ng.com.bitsystems.digitalsignature.command.CoursesCommand;
import ng.com.bitsystems.digitalsignature.model.Courses;

public interface CoursesServices extends CrudService<Courses, Long> {
    CoursesCommand getCourseCommandById(Long id);
}
