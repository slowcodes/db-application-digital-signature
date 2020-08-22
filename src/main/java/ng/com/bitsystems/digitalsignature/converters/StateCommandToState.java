package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.StateCommand;
import ng.com.bitsystems.digitalsignature.model.States;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StateCommandToState implements Converter<StateCommand, States> {

    private CountiesCommandToCounties countiesCommandToCounties;

    public StateCommandToState(CountiesCommandToCounties countiesCommandToCounties) {
        this.countiesCommandToCounties = countiesCommandToCounties;
    }

    @Synchronized
    @Nullable
    @Override
    public States convert(StateCommand stateCommand) {
        if(stateCommand == null){
            return null;
        }
        States states = new States();

        if(stateCommand.getCountiesCommand().size()>0 && stateCommand.getCountiesCommand() != null)
            stateCommand.getCountiesCommand().forEach(countiesCommand -> states.getLgas().add(countiesCommandToCounties.convert(countiesCommand)));

        states.setState(stateCommand.getState());
        states.setId(states.getId());

        return states;
    }
}
