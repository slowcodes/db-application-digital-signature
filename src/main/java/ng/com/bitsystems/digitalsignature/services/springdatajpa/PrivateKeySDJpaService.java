package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.repository.PrivateKeyRepository;
import ng.com.bitsystems.digitalsignature.services.PrivateKeyService;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.HashSet;
import java.util.Set;

@Service
public class PrivateKeySDJpaService implements PrivateKeyService {
    private PrivateKeyRepository privateKeyRepository;

    public PrivateKeySDJpaService(PrivateKeyRepository privateKeyRepository) {
        this.privateKeyRepository = privateKeyRepository;
    }

    @Override
    public Set<PrivateKey> findAll() {
        Set<PrivateKey> privateKeys = new HashSet<>();
        privateKeyRepository.findAll().forEach(privateKeys::add);
        return privateKeys;
    }

    @Override
    public PrivateKey findByID(Long aLong) {
        return privateKeyRepository.findById(aLong).get();
    }

    @Override
    public PrivateKey add(PrivateKey object) {
        return privateKeyRepository.save(object);
    }

    @Override
    public void delete(PrivateKey object) {
        privateKeyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        privateKeyRepository.deleteById(aLong);
    }
}
