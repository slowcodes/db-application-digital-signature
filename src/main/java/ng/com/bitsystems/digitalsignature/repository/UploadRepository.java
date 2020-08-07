package ng.com.bitsystems.digitalsignature.repository;

import ng.com.bitsystems.digitalsignature.model.Uploads;
import org.springframework.data.repository.CrudRepository;

public interface UploadRepository extends CrudRepository<Uploads, Long> {
}
