package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.CountiesCommand;
import ng.com.bitsystems.digitalsignature.model.Counties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CountiesCommandToCounties implements Converter<CountiesCommand, Counties> {

    private StudentsCommandToStudents studentsCommandToStudents;
    private StateCommandToState stateCommandToState;

    public CountiesCommandToCounties(StudentsCommandToStudents studentsCommandToStudents, StateCommandToState stateCommandToState) {
        this.studentsCommandToStudents = studentsCommandToStudents;
        this.stateCommandToState = stateCommandToState;
    }

    @Synchronized
    @Nullable
    @Override
    public Counties convert(CountiesCommand countiesCommand) {

        if(countiesCommand == null)
            return null;

        final Counties counties = new Counties();
        countiesCommand.setId(countiesCommand.getId());
        countiesCommand.setLga(counties.getLga());
        //countiesCommand.setStateCommand(counties.getState());
        //countiesCommand.getStudentCommand(counties.setStudents());
        return  counties;
    }
}
