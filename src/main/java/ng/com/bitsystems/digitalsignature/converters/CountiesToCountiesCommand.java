package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.CountiesCommand;
import ng.com.bitsystems.digitalsignature.model.Counties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CountiesToCountiesCommand implements Converter<Counties, CountiesCommand> {
    private StudentsToStudentsCommand studentsToStudentsCommand;
    private StateToStateCommand stateToStateCommand;

    public CountiesToCountiesCommand(StudentsToStudentsCommand studentsToStudentsCommand, StateToStateCommand stateToStateCommand) {
        this.studentsToStudentsCommand = studentsToStudentsCommand;
        this.stateToStateCommand = stateToStateCommand;
    }

    @Nullable
    @Synchronized
    @Override
    public CountiesCommand convert(Counties counties) {

        if(counties == null){
            return null;
        }

        CountiesCommand countiesCommand = new CountiesCommand();
        countiesCommand.setId(counties.getId());
        countiesCommand.setStateCommand(stateToStateCommand.convert(counties.getState()));
        countiesCommand.setLga(counties.getLga());

        if(counties.getStudents().size()>0 && counties.getStudents() != null ){
            counties.getStudents().forEach(students -> countiesCommand.getStudentCommand().add(studentsToStudentsCommand.convert(students)));
        }

        return countiesCommand;
    }
}
