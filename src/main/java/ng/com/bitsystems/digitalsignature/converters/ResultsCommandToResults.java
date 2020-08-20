package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.model.Results;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ResultsCommandToResults implements Converter<ResultCommand, Results> {

    private SessionCommandToSession sessionCommandToSession;
    private CoursesCommandToCourses coursesCommandToCourses;
    private StudentsCommandToStudents studentsCommandToStudents;

    public ResultsCommandToResults(SessionCommandToSession sessionCommandToSession, CoursesCommandToCourses coursesCommandToCourses, StudentsCommandToStudents studentsCommandToStudents) {
        this.sessionCommandToSession = sessionCommandToSession;
        this.coursesCommandToCourses = coursesCommandToCourses;
        this.studentsCommandToStudents = studentsCommandToStudents;
    }

    @Override
    public Results convert(ResultCommand resultCommand) {
        if(resultCommand == null){
            return null;
        }

        Results results = new Results();
        //results.setCourse();
        results.setExamScore(resultCommand.getExamScore());
        results.setGrade(resultCommand.getGrade());
        //results.setSession(resultCommand.getSessionCommand());
        //results.setStudent();
        return results;
    }
}
