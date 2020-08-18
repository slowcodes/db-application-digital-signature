package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.model.Uploads;
import ng.com.bitsystems.digitalsignature.repository.UploadRepository;
import ng.com.bitsystems.digitalsignature.services.UploadService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UploadSDJpaService implements UploadService {

    private UploadRepository uploadRepository;
    public UploadSDJpaService(UploadRepository uploadRepository) {
        this.uploadRepository = uploadRepository;
    }

    @Override
    public Set<Uploads> findAll() {
        Set<Uploads> uploads = new HashSet<>();
        uploadRepository.findAll().forEach(uploads::add);
        return uploads;
    }

    @Override
    public Uploads findByID(Long aLong) {
        return uploadRepository.findById(aLong).get();
    }

    @Override
    public Uploads add(Uploads object) {
        return uploadRepository.save(object);
    }

    @Override
    public void delete(Uploads object) {
        uploadRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        uploadRepository.deleteById(aLong);
    }
}
