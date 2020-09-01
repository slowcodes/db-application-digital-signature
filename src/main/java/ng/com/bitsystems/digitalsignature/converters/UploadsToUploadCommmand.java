package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.UploadCommand;
import ng.com.bitsystems.digitalsignature.model.Uploads;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UploadsToUploadCommmand implements Converter<Uploads, UploadCommand> {

    private CoursesToCoursesCommand coursesToCoursesCommand;
    private PublicKeysToPublicKeysCommand publicKeysToPublicKeysCommand;
    private PrivateKeysToPrivateKeysCommand privateKeysToPrivateKeysCommand;
    private UsersToUsersCommand usersToUsersCommand;
    private SessionToSessionCommand sessionToSessionCommand;

    public UploadsToUploadCommmand(CoursesToCoursesCommand coursesToCoursesCommand, SessionToSessionCommand sessionToSessionCommand, PublicKeysToPublicKeysCommand publicKeysToPublicKeysCommand, PrivateKeysToPrivateKeysCommand privateKeysToPrivateKeysCommand, UsersToUsersCommand usersToUsersCommand) {
        this.coursesToCoursesCommand = coursesToCoursesCommand;
        this.sessionToSessionCommand = sessionToSessionCommand;
        this.publicKeysToPublicKeysCommand = publicKeysToPublicKeysCommand;
        this.privateKeysToPrivateKeysCommand = privateKeysToPrivateKeysCommand;
        this.usersToUsersCommand = usersToUsersCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public UploadCommand convert(Uploads uploads) {
        if(uploads == null)
            return null;

        UploadCommand uploadCommand = new UploadCommand();
        uploadCommand.setCoursesCommand(coursesToCoursesCommand.convert(uploads.getCourse()));

        uploadCommand.setDateOfUpload(uploads.getUploadedOn());
        uploadCommand.setId(uploads.getId());
        uploadCommand.setSessionCommand(sessionToSessionCommand.convert(uploads.getSession()));
        uploadCommand.setPrivateKeyCommand(privateKeysToPrivateKeysCommand.convert(uploads.getPrivateKeys()));
        uploadCommand.setPublicKeyCommand(publicKeysToPublicKeysCommand.convert(uploads.getPublicKeys()));
        uploadCommand.setUsersCommand(usersToUsersCommand.convert(uploads.getOwner()));

        return uploadCommand;
    }
}
