package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.PublicKeyCommand;
import ng.com.bitsystems.digitalsignature.model.PublicKeys;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PublicKeysToPublicKeysCommand implements Converter<PublicKeys, PublicKeyCommand> {
    private UsersToUsersCommand usersToUsersCommand;
    private StudentsToStudentsCommand studentsToStudentsCommand;
    private PrivateKeysToPrivateKeysCommand privateKeysToPrivateKeysCommand;

    public PublicKeysToPublicKeysCommand(UsersToUsersCommand usersToUsersCommand, StudentsToStudentsCommand studentsToStudentsCommand, PrivateKeysToPrivateKeysCommand privateKeysToPrivateKeysCommand) {
        this.usersToUsersCommand = usersToUsersCommand;
        this.studentsToStudentsCommand = studentsToStudentsCommand;
        this.privateKeysToPrivateKeysCommand = privateKeysToPrivateKeysCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public PublicKeyCommand convert(PublicKeys publicKeys) {
        if(publicKeys == null){
            return null;
        }

        PublicKeyCommand publicKeyCommand = new PublicKeyCommand();
        publicKeyCommand.setCreatedAt(publicKeys.getCreatedAt());
        publicKeyCommand.setId(publicKeys.getId());
        publicKeyCommand.setPublicKey(publicKeys.getPublickey());
        publicKeyCommand.setPrivateKeyCommand(privateKeysToPrivateKeysCommand.convert(publicKeys.getPrivateKeys()));

        if(publicKeys.getUsers().size()>0 && publicKeys.getUsers() !=null){
            publicKeys.getUsers().forEach(users -> publicKeyCommand.getUsersCommands().add(usersToUsersCommand.convert(users)));
        }

        if(publicKeys.getStudents().size()>0 && publicKeys.getStudents() !=null){
            publicKeys.getStudents().forEach(students -> publicKeyCommand.getStudentCommands().add(studentsToStudentsCommand.convert(students)));
        }

        return publicKeyCommand;
    }
}
