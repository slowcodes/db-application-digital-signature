package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.CoursesCommand;
import ng.com.bitsystems.digitalsignature.model.Courses;
import ng.com.bitsystems.digitalsignature.model.Departments;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CoursesCommandToCourses implements Converter<CoursesCommand, Courses> {


    @Synchronized
    @Override
    @Nullable
    public Courses convert(CoursesCommand coursesCommand) {

        if(coursesCommand == null){
            return null;
        }
        Courses courses = new Courses();
        courses.setId(coursesCommand.getId());
        courses.setCourseCode(coursesCommand.getCourseCode());
        courses.setCourseTitle(coursesCommand.getCourseTitle());
        courses.setCredits(coursesCommand.getCredits());

//        if(coursesCommand.getResultCommand().size()>0 && coursesCommand.getResultCommand() != null){
//            coursesCommand.getResultCommand().forEach(resultCommand -> courses.getResults().add(resultsCommandToResults.convert(resultCommand)));
//        }

        if(coursesCommand.getDepartmentId() != null){
            Departments departments = new Departments();
            departments.setId(coursesCommand.getDepartmentId());
            courses.setServiceDepartment(departments);
            departments.addCourse(courses);
        }

//        if (coursesCommand.getUploadCommands().size()>0 && coursesCommand.getUploadCommands() != null){
//            coursesCommand.getUploadCommands().forEach(uploadCommand -> courses.getUploads().add(uploadCommandToUploads.convert(uploadCommand)));
//        }

        return courses;
    }
}
