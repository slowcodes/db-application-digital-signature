package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.StudentCommand;
import ng.com.bitsystems.digitalsignature.model.Students;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentsCommandToStudents implements Converter<StudentCommand, Students> {

    private CountiesCommandToCounties countiesCommandToCounties;
    private DepartmentCommandToDepartment departmentCommandToDepartment;

    public StudentsCommandToStudents(CountiesCommandToCounties countiesCommandToCounties,
                                     DepartmentCommandToDepartment departmentCommandToDepartment) {
        this.countiesCommandToCounties = countiesCommandToCounties;
        this.departmentCommandToDepartment = departmentCommandToDepartment;
    }

    @Override
    public Students convert(StudentCommand studentCommand) {
        if(studentCommand == null)
            return null;

        final Students students = new Students();
        //students.setCounty();
        //students.setDepartment();
        students.setMatricNumber(studentCommand.getMatricNumber());
        //students.setPublicKeys();
        students.setFirstName(studentCommand.getFirstName());
        students.setFirstName(studentCommand.getFirstName());
        students.setSex(studentCommand.getSex());
        return students;
    }
}
