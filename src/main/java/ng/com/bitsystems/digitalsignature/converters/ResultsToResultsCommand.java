package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.model.Results;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ResultsToResultsCommand implements Converter<Results, ResultCommand> {


    @Synchronized
    @Nullable
    @Override
    public ResultCommand convert(Results results) {
        if(results == null){
            return null;
        }

        ResultCommand resultCommand = new ResultCommand();
        resultCommand.setId(results.getId());
        if (results.getCourse() != null ){
            resultCommand.setCourseId(results.getCourse().getId());
        }
        resultCommand.setExamScore(results.getExamScore());

        if (results.getSession() != null)
            resultCommand.setSessionId(results.getSession().getId());

        resultCommand.setTestScore(results.getTestScore());
        resultCommand.setGrade(results.getGrade());

        if (results.getStudent() != null)
            resultCommand.setStudentId(results.getStudent().getId());

        resultCommand.setId(results.getId());
        return resultCommand;
    }
}
