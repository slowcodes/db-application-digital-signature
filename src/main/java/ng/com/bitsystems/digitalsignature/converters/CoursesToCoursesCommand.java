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
    private StudentsToStudentsCommand studentsToStudentsCommand;
    private UploadsToUploadCommmand uploadsToUploadCommmand;

    public CoursesToCoursesCommand(DepartmentsToDepartmentCommand departmentsToDepartmentCommand, StudentsToStudentsCommand studentsToStudentsCommand, UploadsToUploadCommmand uploadsToUploadCommmand) {
        this.departmentsToDepartmentCommand = departmentsToDepartmentCommand;
        this.studentsToStudentsCommand = studentsToStudentsCommand;
        this.uploadsToUploadCommmand = uploadsToUploadCommmand;
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
        //coursesCommand.setDepartmentCommand();
        //coursesCommand.setStudentCommands();
        //coursesCommand.setUploadCommands();
        return coursesCommand;
    }
}
