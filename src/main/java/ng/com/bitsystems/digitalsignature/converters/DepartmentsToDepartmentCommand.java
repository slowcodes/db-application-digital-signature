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

    public DepartmentsToDepartmentCommand(CoursesToCoursesCommand coursesToCoursesCommand) {
        this.coursesToCoursesCommand = coursesToCoursesCommand;

    }

    @Synchronized
    @Nullable
    @Override
    public DepartmentCommand convert(Departments departments) {

        if(departments == null){
            return null;
        }
        DepartmentCommand departmentCommand = new DepartmentCommand();

        if(departments.getCourses().size()>0 && departments.getCourses() != null)
            departments.getCourses().forEach(courses -> departmentCommand.getCoursesCommand().add(coursesToCoursesCommand.convert(courses)));

        departmentCommand.setDepartment(departments.getDepartment());
        if(departments.getFaculty() !=null){
            departmentCommand.setFacultiesId(departments.getFaculty().getId());
        }
        return departmentCommand;
    }

}
