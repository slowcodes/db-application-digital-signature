package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.CountiesCommand;
import ng.com.bitsystems.digitalsignature.model.Counties;
import ng.com.bitsystems.digitalsignature.model.States;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CountiesCommandToCounties implements Converter<CountiesCommand, Counties> {


    @Synchronized
    @Nullable
    @Override
    public Counties convert(CountiesCommand countiesCommand) {

        if(countiesCommand == null)
            return null;

        final Counties counties = new Counties();
        counties.setId(countiesCommand.getId());

        if(countiesCommand.getId() != null){
            States states = new States();
            states.setId(countiesCommand.getStateId());
            counties.setState(states);
            states.addCounties(counties);
        }

        counties.setLga(countiesCommand.getLga());
        //counties.setState(stateCommandToState.convert(countiesCommand.getStateCommand()));

//        if(countiesCommand.getStudentCommand().size()>0 && countiesCommand.getStudentCommand() != null){
//            countiesCommand.getStudentCommand().forEach(studentCommand -> counties.getStudents().add(studentsCommandToStudents.convert(studentCommand)));
//        }

        return  counties;
    }
}
