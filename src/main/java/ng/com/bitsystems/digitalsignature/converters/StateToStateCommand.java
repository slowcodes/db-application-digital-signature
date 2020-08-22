package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.StateCommand;
import ng.com.bitsystems.digitalsignature.model.States;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StateToStateCommand implements Converter<States, StateCommand> {

    private CountiesToCountiesCommand countiesToCountiesCommand;

    public StateToStateCommand(CountiesToCountiesCommand countiesToCountiesCommand) {
        this.countiesToCountiesCommand = countiesToCountiesCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public StateCommand convert(States states) {
        if(states == null){
            return null;
        }
        StateCommand stateCommand = new StateCommand();

        if(states.getLgas().size()>0 && states.getLgas() != null)
            states.getLgas().forEach(lga -> stateCommand.getCountiesCommand().add(countiesToCountiesCommand.convert(lga)) );
        stateCommand.setId(states.getId());
        stateCommand.setState(states.getState());
        return stateCommand;
    }
}
