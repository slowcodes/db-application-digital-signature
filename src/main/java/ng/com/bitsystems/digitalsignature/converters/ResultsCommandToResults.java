package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.model.Results;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
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

    @Synchronized
    @Nullable
    @Override
    public Results convert(ResultCommand resultCommand) {
        if(resultCommand == null){
            return null;
        }

        Results results = new Results();
        results.setCourse(coursesCommandToCourses.convert(resultCommand.getCoursesCommand()));
        results.setExamScore(resultCommand.getExamScore());
        results.setGrade(resultCommand.getGrade());
        results.setSession(sessionCommandToSession.convert(resultCommand.getSessionCommand()));
        results.setStudent(studentsCommandToStudents.convert(resultCommand.getStudentCommand()));

        return results;
    }
}
