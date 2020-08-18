package ng.com.bitsystems.digitalsignature.repository;

import ng.com.bitsystems.digitalsignature.model.PublicKeys;
import org.springframework.data.repository.CrudRepository;

public interface PublicKeyRepository extends CrudRepository<PublicKeys, Long> {
}
