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
    private StudentsToStudentsCommand studentsToStudentsCommand;

    public DepartmentCommandToDepartment(FacultiesCommandToFaculties facultiesCommandToFaculties,
                                         CoursesCommandToCourses coursesCommandToCourses,
                                         StudentsToStudentsCommand studentsToStudentsCommand) {
        this.facultiesCommandToFaculties = facultiesCommandToFaculties;
        this.coursesCommandToCourses = coursesCommandToCourses;
        this.studentsToStudentsCommand = studentsToStudentsCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public Departments convert(DepartmentCommand departmentCommand) {
        if(departmentCommand == null){
            return null;
        }
        Departments departments = new Departments();
        //departments.setCourses(departmentCommand.getCoursesCommand());
        departments.setDepartment(departmentCommand.getDepartment());
        //departments.setFaculty(departmentCommand.getFacultiesCommand());
        //departments.setStudents();
        departments.setId(departmentCommand.getId());
        return departments;
    }
}
