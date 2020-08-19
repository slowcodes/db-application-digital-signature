package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.CountiesCommand;
import ng.com.bitsystems.digitalsignature.model.Counties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class CountiesCommandToCounties implements Converter<Counties, CountiesCommand> {

    @Synchronized
    @Nullable
    @Override
    public CountiesCommand convert(Counties counties) {

        if(counties == null)
            return null;

        final CountiesCommand countiesCommand = new CountiesCommand();
        countiesCommand.setId(counties.getId());
        countiesCommand.setLga(counties.getLga());
        //countiesCommand.setStateCommand(counties.getState());
        //countiesCommand.getStudentCommand(counties.setStudents());
        return  countiesCommand;
    }
}
