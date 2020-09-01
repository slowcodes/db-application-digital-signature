package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.model.Results;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ResultsCommandToResults implements Converter<ResultCommand, Results> {

    private StudentsCommandToStudents studentsCommandToStudents;
    private UploadCommandToUploads uploadCommandToUploads;

    public ResultsCommandToResults(StudentsCommandToStudents studentsCommandToStudents, UploadCommandToUploads uploadCommandToUploads) {
        this.studentsCommandToStudents = studentsCommandToStudents;
        this.uploadCommandToUploads = uploadCommandToUploads;
    }

    @Synchronized
    @Nullable
    @Override
    public Results convert(ResultCommand resultCommand) {

        if(resultCommand == null)
            return null;

        Results results = new Results();
        results.setId(resultCommand.getId());
        results.setExamScore(resultCommand.getExamScore());
        results.setTestScore(resultCommand.getTestScore());
        results.setStudent(studentsCommandToStudents.convert(resultCommand.getStudentCommand()));
        results.setUpload(uploadCommandToUploads.convert(resultCommand.getUploadCommand()));
        return results;
    }
}
