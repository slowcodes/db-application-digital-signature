package ng.com.bitsystems.digitalsignature.repository;

import ng.com.bitsystems.digitalsignature.model.Students;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Students, Long> {
}
