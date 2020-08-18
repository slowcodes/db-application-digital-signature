package ng.com.bitsystems.digitalsignature.repository;

import org.springframework.data.repository.CrudRepository;

import java.security.PrivateKey;

public interface PrivateKeyRepository extends CrudRepository<PrivateKey, Long> {
}
