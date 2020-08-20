package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.StateCommand;
import ng.com.bitsystems.digitalsignature.model.States;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StateToStateCommand implements Converter<States, StateCommand> {



    @Override
    public StateCommand convert(States states) {
        if(states == null){
            return null;
        }
        StateCommand stateCommand = new StateCommand();
        //stateCommand.setCountiesCommand();
        stateCommand.setId(states.getId());
        stateCommand.setState(states.getState());
        return stateCommand;
    }
}
