package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.model.Results;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ResultsToResultsCommand implements Converter<Results, ResultCommand> {

    private StudentsToStudentsCommand studentsToStudentsCommand;


    public ResultsToResultsCommand(StudentsToStudentsCommand studentsToStudentsCommand) {
        this.studentsToStudentsCommand = studentsToStudentsCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public ResultCommand convert(Results results) {
        if(results == null){
            return null;
        }

        ResultCommand resultCommand = new ResultCommand();
        resultCommand.setId(results.getId());

        if(results.getId() != null){
            resultCommand.setUploadId(results.getUpload().getId());
        }

        resultCommand.setExamScore(results.getExamScore());
        resultCommand.setTestScore(results.getTestScore());
        resultCommand.setStudentCommand(studentsToStudentsCommand.convert(results.getStudent()));

        return resultCommand;
    }
}
