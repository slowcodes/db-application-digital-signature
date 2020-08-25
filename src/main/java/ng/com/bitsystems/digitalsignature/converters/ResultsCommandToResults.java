package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.model.Courses;
import ng.com.bitsystems.digitalsignature.model.Results;
import ng.com.bitsystems.digitalsignature.model.Sessions;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ResultsCommandToResults implements Converter<ResultCommand, Results> {


    @Synchronized
    @Nullable
    @Override
    public Results convert(ResultCommand resultCommand) {

        if(resultCommand == null)
            return null;

        Results results = new Results();
        results.setId(resultCommand.getId());

        if(resultCommand.getCourseId() != null){
            Courses courses = new Courses();
            courses.setId(resultCommand.getCourseId());
            results.setCourse(courses);
            courses.addResult(results);
        }

        results.setExamScore(resultCommand.getExamScore());
        results.setGrade(resultCommand.getGrade());

        if (resultCommand.getSessionId() != null){
            Sessions sessions = new Sessions();
            sessions.setId(resultCommand.getSessionId());
            results.setSession(sessions);
            sessions.addResult(results);
        }
        return results;
    }
}
