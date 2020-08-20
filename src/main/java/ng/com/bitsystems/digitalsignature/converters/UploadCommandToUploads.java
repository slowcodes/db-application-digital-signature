package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.UploadCommand;
import ng.com.bitsystems.digitalsignature.model.Uploads;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UploadCommandToUploads implements Converter<UploadCommand, Uploads> {
    @Override
    public Uploads convert(UploadCommand uploadCommand) {
        return null;
    }
}
