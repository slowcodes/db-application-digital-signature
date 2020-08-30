package ng.com.bitsystems.digitalsignature.services;

import ng.com.bitsystems.digitalsignature.command.UploadCommand;
import ng.com.bitsystems.digitalsignature.model.Uploads;

public interface UploadService extends CrudService<Uploads, Long> {

    UploadCommand addUploadCommand(UploadCommand uploadCommand);
}
