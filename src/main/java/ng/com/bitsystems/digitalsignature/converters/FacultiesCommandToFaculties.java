package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.FacultiesCommand;
import ng.com.bitsystems.digitalsignature.model.Faculties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FacultiesCommandToFaculties implements Converter<FacultiesCommand, Faculties> {

    private FacultiesToFacultiesCommand facultiesToFacultiesCommand;
    private DepartmentCommandToDepartment departmentCommandToDepartment;

    public FacultiesCommandToFaculties(FacultiesToFacultiesCommand facultiesToFacultiesCommand,
                                       DepartmentCommandToDepartment departmentCommandToDepartment) {
        this.facultiesToFacultiesCommand = facultiesToFacultiesCommand;
        this.departmentCommandToDepartment = departmentCommandToDepartment;
    }

    @Override
    public Faculties convert(FacultiesCommand facultiesCommand) {

        if(facultiesCommand == null){
            return null;
        }
        Faculties faculties = new Faculties();
        //faculties.setDepartments();
        //faculties.setFaculty(facultiesCommand.getFaculty());
        faculties.setId(facultiesCommand.getId());
        return faculties;
    }
}
