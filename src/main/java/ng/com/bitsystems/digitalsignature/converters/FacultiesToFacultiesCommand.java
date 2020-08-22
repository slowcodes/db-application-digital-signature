package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.FacultiesCommand;
import ng.com.bitsystems.digitalsignature.model.Faculties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class FacultiesToFacultiesCommand implements Converter<Faculties, FacultiesCommand> {
    private DepartmentsToDepartmentCommand departmentsToDepartmentCommand;

    public FacultiesToFacultiesCommand(DepartmentsToDepartmentCommand departmentsToDepartmentCommand) {
        this.departmentsToDepartmentCommand = departmentsToDepartmentCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public FacultiesCommand convert(Faculties faculties) {

        if(faculties == null){
            return null;
        }
        FacultiesCommand facultiesCommand = new FacultiesCommand();
        facultiesCommand.setFaculty(facultiesCommand.getFaculty());

        if (faculties.getDepartments().size()>0 && faculties.getDepartments() != null)
            faculties.getDepartments().forEach(departments -> facultiesCommand.getDepartmentCommands().add(departmentsToDepartmentCommand.convert(departments)));

        faculties.setId(faculties.getId());
        return facultiesCommand;
    }
}
