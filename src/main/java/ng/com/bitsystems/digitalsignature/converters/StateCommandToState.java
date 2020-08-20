package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.StateCommand;
import ng.com.bitsystems.digitalsignature.model.States;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StateCommandToState implements Converter<StateCommand, States> {

    private StateToStateCommand stateToStateCommand;

    public StateCommandToState(StateToStateCommand stateToStateCommand) {
        this.stateToStateCommand = stateToStateCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public States convert(StateCommand stateCommand) {
        if(stateCommand == null){
            return null;
        }
        States states = new States();
        //states.setLgas(stateToStateCommand.);
        states.setState(stateCommand.getState());
        states.setId(states.getId());
        return states;
    }
}
