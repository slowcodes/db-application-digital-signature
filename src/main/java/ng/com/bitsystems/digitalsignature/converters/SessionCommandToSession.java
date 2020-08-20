package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.SessionCommand;
import ng.com.bitsystems.digitalsignature.model.Sessions;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SessionCommandToSession implements Converter<SessionCommand, Sessions> {

    @Synchronized
    @Nullable
    @Override
    public Sessions convert(SessionCommand sessionCommand) {
        if(sessionCommand == null){
            return null;
        }

        Sessions sessions = new Sessions();
        sessions.setDescription(sessionCommand.getDescription());
        //sessions.setResults(sessionCommand);
        sessions.setSession(sessionCommand.getSession());
        sessions.setId(sessionCommand.getId());
        return sessions;
    }
}
