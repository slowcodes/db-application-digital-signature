package ng.com.bitsystems.digitalsignature.services;

import ng.com.bitsystems.digitalsignature.command.StudentCommand;
import ng.com.bitsystems.digitalsignature.model.Students;

import java.util.List;

public interface StudentsService extends CrudService<Students, Long> {
    StudentCommand getCommandByMatricNumber(String matricNumber);
    List<Students> findByMatricNumber(String matricNumber);
}
