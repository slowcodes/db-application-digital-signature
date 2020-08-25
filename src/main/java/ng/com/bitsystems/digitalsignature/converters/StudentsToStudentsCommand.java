package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.StudentCommand;
import ng.com.bitsystems.digitalsignature.model.Students;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StudentsToStudentsCommand implements Converter<Students, StudentCommand> {

    private DepartmentsToDepartmentCommand departmentsToDepartmentCommand;
    private ResultsToResultsCommand resultsToResultsCommand;
    private PublicKeysToPublicKeysCommand publicKeysToPublicKeysCommand;
    private CountiesToCountiesCommand countiesToCountiesCommand;

    public StudentsToStudentsCommand(DepartmentsToDepartmentCommand departmentsToDepartmentCommand,
                                     ResultsToResultsCommand resultsToResultsCommand,
                                     PublicKeysToPublicKeysCommand publicKeysToPublicKeysCommand,
                                     CountiesToCountiesCommand countiesToCountiesCommand) {
        this.departmentsToDepartmentCommand = departmentsToDepartmentCommand;
        this.resultsToResultsCommand = resultsToResultsCommand;
        this.publicKeysToPublicKeysCommand = publicKeysToPublicKeysCommand;
        this.countiesToCountiesCommand = countiesToCountiesCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public StudentCommand convert(Students students) {
        if (students == null)
            return null;

        StudentCommand studentCommand = new StudentCommand();
        studentCommand.setId(students.getId());
        studentCommand.setFirstName(students.getFirstName());
        studentCommand.setDepartmentCommand(departmentsToDepartmentCommand.convert(students.getDepartment()));
        studentCommand.setLastName(students.getLastName());
        studentCommand.setMatricNumber(students.getMatricNumber());
        studentCommand.setCountiesCommand(countiesToCountiesCommand.convert(students.getCounty()));

        if(students.getPublicKeys().size()>0 && students.getPublicKeys() != null)
            students.getPublicKeys().forEach(publicKeys -> studentCommand.getPublicKeyCommands().add(publicKeysToPublicKeysCommand.convert(publicKeys)));

        if(students.getResults().size()>0 && students.getResults() != null)
            students.getResults().forEach(results -> studentCommand.getResultCommands().add(resultsToResultsCommand.convert(results)));

        studentCommand.setSex(students.getSex());
        studentCommand.setId(students.getId());

        return studentCommand;
    }
}