package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.StudentCommand;
import ng.com.bitsystems.digitalsignature.model.Students;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StudentsCommandToStudents implements Converter<StudentCommand, Students> {

    private CountiesCommandToCounties countiesCommandToCounties;
    private DepartmentCommandToDepartment departmentCommandToDepartment;
    private PublicKeysCommandToPublicKeys publicKeysCommandToPublicKeys;
    private ResultsCommandToResults resultsCommandToResults;

    public StudentsCommandToStudents(CountiesCommandToCounties countiesCommandToCounties,
                                     DepartmentCommandToDepartment departmentCommandToDepartment,
                                     PublicKeysCommandToPublicKeys publicKeysCommandToPublicKeys,
                                     ResultsCommandToResults resultsCommandToResults) {
        this.countiesCommandToCounties = countiesCommandToCounties;
        this.departmentCommandToDepartment = departmentCommandToDepartment;
        this.publicKeysCommandToPublicKeys = publicKeysCommandToPublicKeys;
        this.resultsCommandToResults = resultsCommandToResults;
    }

    @Synchronized
    @Nullable
    @Override
    public Students convert(StudentCommand studentCommand) {

        if(studentCommand == null)
            return null;

        final Students students = new Students();

        students.setId(studentCommand.getId());
        students.setCounty(countiesCommandToCounties.convert(studentCommand.getCountiesCommand()));
        students.setDepartment(departmentCommandToDepartment.convert(studentCommand.getDepartmentCommand()));
        students.setMatricNumber(studentCommand.getMatricNumber());

        if(studentCommand.getPublicKeyCommands().size()>0 && studentCommand.getPublicKeyCommands() != null){
            studentCommand.getPublicKeyCommands().forEach(publicKeyCommand -> students.getPublicKeys().add(publicKeysCommandToPublicKeys.convert(publicKeyCommand)));
        }

        students.setFirstName(studentCommand.getFirstName());
        students.setFirstName(studentCommand.getFirstName());
        students.setSex(studentCommand.getSex());

        if(studentCommand.getResultCommands().size()>0 && studentCommand.getResultCommands() != null) {
            studentCommand.getResultCommands().forEach(resultCommand -> students.getResults().add(resultsCommandToResults.convert(resultCommand)));
        }

        return students;
    }
}
