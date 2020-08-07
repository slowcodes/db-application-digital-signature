package ng.com.bitsystems.digitalsignature.repository;

import ng.com.bitsystems.digitalsignature.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository  extends CrudRepository<Users, Long> {
}
