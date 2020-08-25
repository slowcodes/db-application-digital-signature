package ng.com.bitsystems.digitalsignature.repository;

import ng.com.bitsystems.digitalsignature.model.PrivateKeys;
import org.springframework.data.repository.CrudRepository;



public interface PrivateKeyRepository extends CrudRepository<PrivateKeys, Long> {
}
