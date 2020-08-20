package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.SessionCommand;
import ng.com.bitsystems.digitalsignature.model.Sessions;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SessionToSessionCommand implements Converter<Sessions, SessionCommand> {
    @Override
    public SessionCommand convert(Sessions sessions) {
        if(sessions == null){
            return null;
        }

        SessionCommand sessionCommand = new SessionCommand();
        sessionCommand.setDescription(sessions.getDescription());
        //sessionCommand.setResultCommands();
        sessionCommand.setId(sessions.getId());
        return sessionCommand;
    }
}
