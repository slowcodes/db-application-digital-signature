package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.UsersCommand;
import ng.com.bitsystems.digitalsignature.model.Users;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UsersCommandToUsers implements Converter<UsersCommand, Users> {
    private PublicKeysCommandToPublicKeys publicKeysCommandToPublicKeys;
    private UploadCommandToUploads uploadCommandToUploads;
    private UsersPrivilegeCommandToUsersPrivilege usersPrivilegeCommandToUsersPrivilege;

    public UsersCommandToUsers(PublicKeysCommandToPublicKeys publicKeysCommandToPublicKeys,
                               UploadCommandToUploads uploadCommandToUploads,
                               UsersPrivilegeCommandToUsersPrivilege usersPrivilegeCommandToUsersPrivilege) {
        this.publicKeysCommandToPublicKeys = publicKeysCommandToPublicKeys;
        this.uploadCommandToUploads = uploadCommandToUploads;
        this.usersPrivilegeCommandToUsersPrivilege = usersPrivilegeCommandToUsersPrivilege;
    }

    @Synchronized
    @Nullable
    @Override
    public Users convert(UsersCommand usersCommand) {
        if(usersCommand == null)
            return null;

        Users users = new Users();

        if(usersCommand.getUploadCommands().size()>0 && usersCommand.getUploadCommands() != null)
            usersCommand.getUploadCommands().forEach(uploadCommand -> users.getUploads().add(uploadCommandToUploads.convert(uploadCommand)));

        if(usersCommand.getPublicKeyCommands().size()>0 && usersCommand.getPublicKeyCommands() != null)
            usersCommand.getPublicKeyCommands().forEach(publicKeyCommand -> users.getPublicKeys().add(publicKeysCommandToPublicKeys.convert(publicKeyCommand)));

        if (usersCommand.getUserPrivilegeCommands().size()>0 && usersCommand.getUserPrivilegeCommands() != null)
            usersCommand.getUserPrivilegeCommands().forEach(userPrivilegeCommand -> users.getUsersPrivileges().add(usersPrivilegeCommandToUsersPrivilege.convert(userPrivilegeCommand)));

        users.setEmail(usersCommand.getEmail());
        users.setId(usersCommand.getId());
        users.setPassword(users.getPassword());
        users.setUsername(users.getUsername());
        return users;
    }
}
