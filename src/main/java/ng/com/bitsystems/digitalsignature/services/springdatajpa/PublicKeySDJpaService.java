package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.model.PublicKeys;
import ng.com.bitsystems.digitalsignature.repository.PublicKeyRepository;
import ng.com.bitsystems.digitalsignature.services.PublicKeysService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PublicKeySDJpaService implements PublicKeysService {
    private PublicKeyRepository publicKeyRepository;

    public PublicKeySDJpaService(PublicKeyRepository publicKeyRepository) {
        this.publicKeyRepository = publicKeyRepository;
    }

    @Override
    public Set<PublicKeys> findAll() {
        Set<PublicKeys> publicKeys = new HashSet<>();
        publicKeyRepository.findAll().forEach(publicKeys::add);
        return publicKeys;
    }

    @Override
    public PublicKeys findByID(Long aLong) {
        return publicKeyRepository.findById(aLong).get();
    }

    @Override
    public PublicKeys add(PublicKeys object) {
        return publicKeyRepository.save(object);
    }

    @Override
    public void delete(PublicKeys object) {
        publicKeyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        publicKeyRepository.deleteById(aLong);
    }
}
