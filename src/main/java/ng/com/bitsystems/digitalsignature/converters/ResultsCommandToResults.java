package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.model.Results;
import ng.com.bitsystems.digitalsignature.model.Uploads;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ResultsCommandToResults implements Converter<ResultCommand, Results> {

    private StudentsCommandToStudents studentsCommandToStudents;

    public ResultsCommandToResults(StudentsCommandToStudents studentsCommandToStudents) {
        this.studentsCommandToStudents = studentsCommandToStudents;
    }

    @Synchronized
    @Nullable
    @Override
    public Results convert(ResultCommand resultCommand) {

        if(resultCommand == null)
            return null;

        Results results = new Results();
        results.setId(resultCommand.getId());

        if(resultCommand.getUploadId() != null){
            Uploads uploads = new Uploads();
            uploads.setId(resultCommand.getUploadId());
            results.setUpload(uploads);
            uploads.addResult(results);
        }

        results.setExamScore(resultCommand.getExamScore());
        results.setTestScore(resultCommand.getTestScore());
        results.setStudent(studentsCommandToStudents.convert(resultCommand.getStudentCommand()));
        return results;
    }
}
