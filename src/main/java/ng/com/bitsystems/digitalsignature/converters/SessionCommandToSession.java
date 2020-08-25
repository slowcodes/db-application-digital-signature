package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.SessionCommand;
import ng.com.bitsystems.digitalsignature.model.Sessions;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SessionCommandToSession implements Converter<SessionCommand, Sessions> {
//    private ResultsCommandToResults resultsCommandToResults;
//
//    public SessionCommandToSession(ResultsCommandToResults resultsCommandToResults) {
//        this.resultsCommandToResults = resultsCommandToResults;
//    }

    @Synchronized
    @Nullable
    @Override
    public Sessions convert(SessionCommand sessionCommand) {
        if(sessionCommand == null){
            return null;
        }

        Sessions sessions = new Sessions();
        sessions.setDescription(sessionCommand.getDescription());

//        if(sessionCommand.getResultCommands().size()>0 && sessionCommand.getResultCommands() != null)
//            sessionCommand.getResultCommands().forEach(resultCommand -> sessions.getResults().add(resultsCommandToResults.convert(resultCommand)));

        sessions.setSession(sessionCommand.getSession());
        sessions.setId(sessionCommand.getId());
        return sessions;
    }
}
