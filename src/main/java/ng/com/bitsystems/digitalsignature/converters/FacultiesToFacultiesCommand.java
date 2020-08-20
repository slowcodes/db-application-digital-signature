package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.FacultiesCommand;
import ng.com.bitsystems.digitalsignature.model.Faculties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FacultiesToFacultiesCommand implements Converter<Faculties, FacultiesCommand> {


    @Override
    public FacultiesCommand convert(Faculties faculties) {

        if(faculties == null){
            return null;
        }
        FacultiesCommand facultiesCommand = new FacultiesCommand();
        facultiesCommand.setFaculty(facultiesCommand.getFaculty());
        //facultiesCommand.setDepartmentCommands();
        faculties.setId(faculties.getId());
        return facultiesCommand;
    }
}
