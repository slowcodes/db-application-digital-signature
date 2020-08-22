package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.FacultiesCommand;
import ng.com.bitsystems.digitalsignature.model.Faculties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class FacultiesCommandToFaculties implements Converter<FacultiesCommand, Faculties> {

    private DepartmentCommandToDepartment departmentCommandToDepartment;

    public FacultiesCommandToFaculties(DepartmentCommandToDepartment departmentCommandToDepartment) {
        this.departmentCommandToDepartment = departmentCommandToDepartment;
    }

    @Synchronized
    @Nullable
    @Override
    public Faculties convert(FacultiesCommand facultiesCommand) {

        if(facultiesCommand == null){
            return null;
        }
        Faculties faculties = new Faculties();
        if(facultiesCommand.getDepartmentCommands().size()>0 && facultiesCommand.getDepartmentCommands() !=null)
            facultiesCommand.getDepartmentCommands().forEach(departmentCommand -> faculties.getDepartments().add(departmentCommandToDepartment.convert(departmentCommand)));

        faculties.setId(facultiesCommand.getId());
        return faculties;
    }
}
