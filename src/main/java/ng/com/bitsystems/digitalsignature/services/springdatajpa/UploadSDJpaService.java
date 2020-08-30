package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.command.UploadCommand;
import ng.com.bitsystems.digitalsignature.converters.UploadCommandToUploads;
import ng.com.bitsystems.digitalsignature.converters.UploadsToUploadCommmand;
import ng.com.bitsystems.digitalsignature.model.Uploads;
import ng.com.bitsystems.digitalsignature.repository.UploadRepository;
import ng.com.bitsystems.digitalsignature.services.UploadService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class UploadSDJpaService implements UploadService {

    private UploadRepository uploadRepository;
    private UploadCommandToUploads uploadCommandToUploads;
    private UploadsToUploadCommmand uploadsToUploadCommmand;

    public UploadSDJpaService(UploadRepository uploadRepository,
                              UploadCommandToUploads uploadCommandToUploads,
                              UploadsToUploadCommmand uploadsToUploadCommmand) {
        this.uploadRepository = uploadRepository;
        this.uploadCommandToUploads = uploadCommandToUploads;
        this.uploadsToUploadCommmand = uploadsToUploadCommmand;
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


    @Override
    @Transactional
    public UploadCommand addUploadCommand(UploadCommand uploadCommand){
        Uploads detachedUpload = uploadCommandToUploads.convert(uploadCommand);
        Uploads uploads = add(detachedUpload);
        return uploadsToUploadCommmand.convert(uploads);
    }

}
