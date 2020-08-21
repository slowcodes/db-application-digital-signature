package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.StudentCommand;
import ng.com.bitsystems.digitalsignature.model.Students;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentsCommandToStudents implements Converter<StudentCommand, Students> {

    private CountiesCommandToCounties countiesCommandToCounties;
    private DepartmentCommandToDepartment departmentCommandToDepartment;
    private PublicKeysCommandToPublicKeys publicKeysCommandToPublicKeys;

    public StudentsCommandToStudents(CountiesCommandToCounties countiesCommandToCounties,
                                     DepartmentCommandToDepartment departmentCommandToDepartment,
                                     PublicKeysCommandToPublicKeys publicKeysCommandToPublicKeys) {
        this.countiesCommandToCounties = countiesCommandToCounties;
        this.departmentCommandToDepartment = departmentCommandToDepartment;
        this.publicKeysCommandToPublicKeys = publicKeysCommandToPublicKeys;
    }

    @Override
    public Students convert(StudentCommand studentCommand) {
        if(studentCommand == null)
            return null;

        final Students students = new Students();
        students.setCounty(countiesCommandToCounties.convert(studentCommand.getCountiesCommand()));
        students.setDepartment(departmentCommandToDepartment.convert(studentCommand.getDepartmentCommand()));
        students.setMatricNumber(studentCommand.getMatricNumber());

        if(studentCommand.getPublicKeyCommands().size()>0 && studentCommand.getPublicKeyCommands() != null){
            studentCommand.getPublicKeyCommands().forEach(publicKeyCommand -> students.getPublicKeys().add(publicKeysCommandToPublicKeys.convert(publicKeyCommand)));
        }
        students.setFirstName(studentCommand.getFirstName());
        students.setFirstName(studentCommand.getFirstName());
        students.setSex(studentCommand.getSex());
        return students;
    }
}
