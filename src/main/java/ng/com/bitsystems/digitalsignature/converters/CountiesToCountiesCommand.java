package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.CountiesCommand;
import ng.com.bitsystems.digitalsignature.model.Counties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CountiesToCountiesCommand implements Converter<Counties, CountiesCommand> {


    @Synchronized
    @Nullable
    @Override
    public CountiesCommand convert(Counties counties) {

        if(counties == null){
            return null;
        }

        CountiesCommand countiesCommand = new CountiesCommand();
        countiesCommand.setId(counties.getId());

        if(countiesCommand.getStateCommand() !=null)
            countiesCommand.setStateId(counties.getState().getId());

        //countiesCommand.setStateCommand(stateToStateCommand.convert(counties.getState()));
        countiesCommand.setLga(counties.getLga());

//        if(counties.getStudents().size()>0 && counties.getStudents() != null ){
//            counties.getStudents().forEach(students -> countiesCommand.getStudentCommand().add(studentsToStudentsCommand.convert(students)));
//        }

        return countiesCommand;
    }
}
