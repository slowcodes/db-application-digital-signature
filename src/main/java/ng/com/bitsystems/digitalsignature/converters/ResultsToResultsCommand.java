package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.model.Results;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ResultsToResultsCommand implements Converter<Results, ResultCommand> {
    private CoursesToCoursesCommand coursesToCoursesCommand;
    private SessionToSessionCommand sessionToSessionCommand;

    public ResultsToResultsCommand(CoursesToCoursesCommand coursesToCoursesCommand, SessionToSessionCommand sessionToSessionCommand) {
        this.coursesToCoursesCommand = coursesToCoursesCommand;
        this.sessionToSessionCommand = sessionToSessionCommand;
    }

    @Override
    public ResultCommand convert(Results results) {
        if(results == null){
            return null;
        }

        ResultCommand resultCommand = new ResultCommand();
        resultCommand.setCoursesCommand(coursesToCoursesCommand.convert(results.getCourse()));
        resultCommand.setExamScore(results.getExamScore());
        resultCommand.setSessionCommand(sessionToSessionCommand.convert(results.getSession()));
        resultCommand.setTestScore(results.getTestScore());
        resultCommand.setGrade(results.getGrade());
        resultCommand.setId(results.getId());
        return resultCommand;
    }
}
