package ng.com.bitsystems.digitalsignature.services;

import ng.com.bitsystems.digitalsignature.command.StudentCommand;
import ng.com.bitsystems.digitalsignature.model.Students;

public interface StudentsService extends CrudService<Students, Long> {
    StudentCommand getCommandByMatricNumber(String matricNumber);
    Students findByMatricNumber(String matricNumber);
}
