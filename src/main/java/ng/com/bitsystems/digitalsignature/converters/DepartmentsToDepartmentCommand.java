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
    private DepartmentsToDepartmentCommand departmentsToDepartmentCommand;
    private FacultiesToFacultiesCommand facultiesToFacultiesCommand;

    public DepartmentsToDepartmentCommand(CoursesToCoursesCommand coursesToCoursesCommand,
                                          DepartmentsToDepartmentCommand departmentsToDepartmentCommand,
                                          FacultiesToFacultiesCommand facultiesToFacultiesCommand) {
        this.coursesToCoursesCommand = coursesToCoursesCommand;
        this.departmentsToDepartmentCommand = departmentsToDepartmentCommand;
        this.facultiesToFacultiesCommand = facultiesToFacultiesCommand;
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
        departmentCommand.setFacultiesCommand(facultiesToFacultiesCommand.convert(departments.getFaculty()));
        return departmentCommand;
    }

}
