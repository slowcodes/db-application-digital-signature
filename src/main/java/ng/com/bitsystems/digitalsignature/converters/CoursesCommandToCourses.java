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
    private UploadCommandToUploads uploadCommandToUploads;

    public CoursesCommandToCourses(ResultsCommandToResults resultsCommandToResults,
                                   DepartmentCommandToDepartment departmentCommandToDepartment,
                                   UploadCommandToUploads uploadCommandToUploads) {
        this.resultsCommandToResults = resultsCommandToResults;
        this.departmentCommandToDepartment = departmentCommandToDepartment;
        this.uploadCommandToUploads = uploadCommandToUploads;
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

        if(coursesCommand.getResultCommand().size()>0 && coursesCommand.getResultCommand() != null){
            coursesCommand.getResultCommand().forEach(resultCommand -> courses.getResults().add(resultsCommandToResults.convert(resultCommand)));
        }

        courses.setServiceDepartment(departmentCommandToDepartment.convert(coursesCommand.getDepartmentCommand()));

        if (coursesCommand.getUploadCommands().size()>0 && coursesCommand.getUploadCommands() != null){
            coursesCommand.getUploadCommands().forEach(uploadCommand -> courses.getUploads().add(uploadCommandToUploads.convert(uploadCommand)));
        }
        return courses;
    }
}
