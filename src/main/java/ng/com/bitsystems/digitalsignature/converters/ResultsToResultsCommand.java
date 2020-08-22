package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.model.Results;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ResultsToResultsCommand implements Converter<Results, ResultCommand> {
    private CoursesToCoursesCommand coursesToCoursesCommand;
    private SessionToSessionCommand sessionToSessionCommand;
    private StudentsToStudentsCommand studentsToStudentsCommand;

    public ResultsToResultsCommand(CoursesToCoursesCommand coursesToCoursesCommand,
                                   StudentsToStudentsCommand studentsToStudentsCommand,
                                   SessionToSessionCommand sessionToSessionCommand) {
        this.coursesToCoursesCommand = coursesToCoursesCommand;
        this.sessionToSessionCommand = sessionToSessionCommand;
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
        resultCommand.setCoursesCommand(coursesToCoursesCommand.convert(results.getCourse()));
        resultCommand.setExamScore(results.getExamScore());
        resultCommand.setSessionCommand(sessionToSessionCommand.convert(results.getSession()));
        resultCommand.setTestScore(results.getTestScore());
        resultCommand.setGrade(results.getGrade());
        resultCommand.setStudentCommand(studentsToStudentsCommand.convert(results.getStudent()));
        resultCommand.setId(results.getId());
        return resultCommand;
    }
}
