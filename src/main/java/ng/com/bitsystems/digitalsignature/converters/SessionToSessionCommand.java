package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.SessionCommand;
import ng.com.bitsystems.digitalsignature.model.Sessions;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SessionToSessionCommand implements Converter<Sessions, SessionCommand> {
//    private ResultsToResultsCommand resultsToResultsCommand;
//
//    public SessionToSessionCommand(ResultsToResultsCommand resultsToResultsCommand) {
//        this.resultsToResultsCommand = resultsToResultsCommand;
//    }

    @Synchronized
    @Nullable
    @Override
    public SessionCommand convert(Sessions sessions) {

        if(sessions == null){
            return null;
        }

        SessionCommand sessionCommand = new SessionCommand();
        sessionCommand.setDescription(sessions.getDescription());

//        if (sessions.getResults().size()>0 && sessions.getResults() != null)
//            sessions.getResults().forEach(results -> sessionCommand.getResultCommands().add(resultsToResultsCommand.convert(results)));

        sessionCommand.setId(sessions.getId());
        return sessionCommand;
    }
}
