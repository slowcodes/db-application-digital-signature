package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.CoursesCommand;
import ng.com.bitsystems.digitalsignature.model.Courses;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CoursesToCoursesCommand implements Converter<Courses, CoursesCommand> {
    private DepartmentsToDepartmentCommand departmentsToDepartmentCommand;
    private UploadsToUploadCommmand uploadsToUploadCommmand;
    private StudentsToStudentsCommand studentsToStudentsCommand;

    public CoursesToCoursesCommand(StudentsToStudentsCommand studentsToStudentsCommand, DepartmentsToDepartmentCommand departmentsToDepartmentCommand, UploadsToUploadCommmand uploadsToUploadCommmand) {
        this.departmentsToDepartmentCommand = departmentsToDepartmentCommand;
        this.uploadsToUploadCommmand = uploadsToUploadCommmand;
        this.studentsToStudentsCommand = studentsToStudentsCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public CoursesCommand convert(Courses courses) {
        
        if(courses == null)
            return null;
        CoursesCommand coursesCommand = new CoursesCommand();
        coursesCommand.setCourseCode(courses.getCourseCode());
        coursesCommand.setCourseTitle(courses.getCourseTitle());
        coursesCommand.setCredits(courses.getCredits());
        coursesCommand.setDepartmentCommand(departmentsToDepartmentCommand.convert(courses.getServiceDepartment()));

        if(courses.getUploads().size()>0 && courses.getUploads() !=null)
            courses.getUploads().forEach(upload -> coursesCommand.getUploadCommands().add(uploadsToUploadCommmand.convert(upload)));

        return coursesCommand;
    }
}
