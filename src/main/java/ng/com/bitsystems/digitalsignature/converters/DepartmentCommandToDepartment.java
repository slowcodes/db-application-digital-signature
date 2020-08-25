package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.DepartmentCommand;
import ng.com.bitsystems.digitalsignature.model.Departments;
import ng.com.bitsystems.digitalsignature.model.Faculties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class DepartmentCommandToDepartment implements Converter<DepartmentCommand, Departments> {

    private CoursesCommandToCourses coursesCommandToCourses;

    public DepartmentCommandToDepartment(CoursesCommandToCourses coursesCommandToCourses) {
        this.coursesCommandToCourses = coursesCommandToCourses;
    }

    @Synchronized
    @Nullable
    @Override
    public Departments convert(DepartmentCommand departmentCommand) {

        if(departmentCommand == null){
            return null;
        }

        Departments departments = new Departments();
        if(departmentCommand.getCoursesCommand().size()>0 && departmentCommand.getCoursesCommand().size() !=0)
            departmentCommand.getCoursesCommand().forEach(coursesCommand -> departments.getCourses().add(coursesCommandToCourses.convert(coursesCommand)));

        departments.setDepartment(departmentCommand.getDepartment());

        if (departmentCommand.getFacultiesId() != null){
            Faculties faculties = new Faculties();
            faculties.setId(departmentCommand.getFacultiesId());
            departments.setFaculty(faculties);
            faculties.addDepartment(departments);
        }

//        if(departmentCommand.getStudentCommands().size()>0 && departmentCommand.getStudentCommands() !=null)
//            departmentCommand.getStudentCommands().forEach(studentCommand -> departments.getStudents().add(studentsCommandToStudents.convert(studentCommand)));

        departments.setId(departmentCommand.getId());
        return departments;
    }
}
