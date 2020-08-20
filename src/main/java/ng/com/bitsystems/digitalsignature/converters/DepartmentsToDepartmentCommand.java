package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.DepartmentCommand;
import ng.com.bitsystems.digitalsignature.model.Departments;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class DepartmentsToDepartmentCommand implements Converter<Departments, DepartmentCommand> {
    private CoursesToCoursesCommand coursesToCoursesCommand;
    private DepartmentCommandToDepartment departmentCommandToDepartment;
    private FacultiesCommandToFaculties facultiesCommandToFaculties;

    public DepartmentsToDepartmentCommand(CoursesToCoursesCommand coursesToCoursesCommand, DepartmentCommandToDepartment departmentCommandToDepartment, FacultiesCommandToFaculties facultiesCommandToFaculties) {
        this.coursesToCoursesCommand = coursesToCoursesCommand;
        this.departmentCommandToDepartment = departmentCommandToDepartment;
        this.facultiesCommandToFaculties = facultiesCommandToFaculties;
    }

    @Synchronized
    @Nullable
    @Override
    public DepartmentCommand convert(Departments departments) {

        if(departments == null){
            return null;
        }
        DepartmentCommand departmentCommand = new DepartmentCommand();
        //departmentCommand.setCoursesCommand(coursesToCoursesCommand.convert(departments.getCourses()));
        //departmentCommand.setDepartment(departments.getDepartment());
        //departmentCommand.setFacultiesCommand();
        departmentCommand.setDepartment(departments.getDepartment());
        departmentCommand.setId(departments.getId());
        return departmentCommand;
    }

}
