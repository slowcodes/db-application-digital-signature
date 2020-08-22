package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.DepartmentCommand;
import ng.com.bitsystems.digitalsignature.model.Departments;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class DepartmentCommandToDepartment implements Converter<DepartmentCommand, Departments> {

    private FacultiesCommandToFaculties facultiesCommandToFaculties;
    private CoursesCommandToCourses coursesCommandToCourses;
    private StudentsCommandToStudents studentsCommandToStudents;

    public DepartmentCommandToDepartment(FacultiesCommandToFaculties facultiesCommandToFaculties,
                                         CoursesCommandToCourses coursesCommandToCourses,
                                         StudentsCommandToStudents studentsCommandToStudents) {
        this.facultiesCommandToFaculties = facultiesCommandToFaculties;
        this.coursesCommandToCourses = coursesCommandToCourses;
        this.studentsCommandToStudents = studentsCommandToStudents;
    }

    @Synchronized
    @Nullable
    @Override
    public Departments convert(DepartmentCommand departmentCommand) {
        if(departmentCommand == null){
            return null;
        }

        Departments departments = new Departments();
        if(departmentCommand.getCoursesCommand().size()>0 && departmentCommand.getCoursesCommand().size() !=0)
            departmentCommand.getCoursesCommand().forEach(coursesCommand -> departments.getCourses().add(coursesCommandToCourses.convert(coursesCommand)));

        departments.setDepartment(departmentCommand.getDepartment());
        departments.setFaculty(facultiesCommandToFaculties.convert(departmentCommand.getFacultiesCommand()));

        if(departmentCommand.getStudentCommands().size()>0 && departmentCommand.getStudentCommands() !=null)
            departmentCommand.getStudentCommands().forEach(studentCommand -> departments.getStudents().add(studentsCommandToStudents.convert(studentCommand)));

        departments.setId(departmentCommand.getId());
        return departments;
    }
}
