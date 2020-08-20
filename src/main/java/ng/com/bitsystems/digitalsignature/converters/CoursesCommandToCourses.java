package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.CoursesCommand;
import ng.com.bitsystems.digitalsignature.model.Courses;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CoursesCommandToCourses implements Converter<CoursesCommand, Courses> {

    private ResultsCommandToResults resultsCommandToResults;
    private DepartmentCommandToDepartment departmentCommandToDepartment;

    public CoursesCommandToCourses(ResultsCommandToResults resultsCommandToResults, DepartmentCommandToDepartment departmentCommandToDepartment) {
        this.resultsCommandToResults = resultsCommandToResults;
        this.departmentCommandToDepartment = departmentCommandToDepartment;
    }

    @Synchronized
    @Override
    @Nullable
    public Courses convert(CoursesCommand coursesCommand) {

        if(coursesCommand == null){
            return null;
        }
        Courses courses = new Courses();
        courses.setCourseCode(coursesCommand.getCourseCode());
        courses.setCourseTitle(coursesCommand.getCourseTitle());
        courses.setCredits(courses.getCredits());
        //courses.setResults();
        //courses.setServiceDepartment();
        //courses.setUploads();
        return courses;
    }
}
