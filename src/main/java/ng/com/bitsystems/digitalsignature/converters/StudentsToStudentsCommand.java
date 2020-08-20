package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.StudentCommand;
import ng.com.bitsystems.digitalsignature.model.Students;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentsToStudentsCommand implements Converter<Students, StudentCommand> {


    @Override
    public StudentCommand convert(Students students) {
        if (students == null)
            return null;

        StudentCommand studentCommand = new StudentCommand();
        studentCommand.setFirstName(students.getFirstName());
        //studentCommand.setDepartmentCommand();
        studentCommand.setLastName(students.getLastName());
        studentCommand.setMatricNumber(students.getMatricNumber());
        //studentCommand.setPublicKeyCommands();
        //studentCommand.setResultCommands();
        studentCommand.setSex(students.getSex());
        return studentCommand;
    }
}