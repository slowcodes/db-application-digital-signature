package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.PublicKeyCommand;
import ng.com.bitsystems.digitalsignature.model.PublicKeys;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PublicKeysCommandToPublicKeys implements Converter<PublicKeyCommand, PublicKeys> {



    @Synchronized
    @Nullable
    @Override
    public PublicKeys convert(PublicKeyCommand publicKeyCommand) {
        if(publicKeyCommand == null){
            return null;
        }

        PublicKeys publicKeys = new PublicKeys();
        publicKeys.setPublickey(publicKeyCommand.getPublicKey());
//        publicKeys.setPrivateKeys(privateKeysCommandToPrivateKeys.convert(publicKeyCommand.getPrivateKeyCommand()));
//        if(publicKeyCommand.getUsersCommands().size()>0 && publicKeyCommand.getUsersCommands() != null)
//            publicKeyCommand.getUsersCommands().forEach(usersCommand -> publicKeys.getUsers().add(usersCommandToUsers.convert(usersCommand)));

//        if(publicKeyCommand.getStudentCommands().size()>0 && publicKeyCommand.getStudentCommands() != null)
//            publicKeyCommand.getStudentCommands().forEach(studentCommand -> publicKeys.getStudents().add(studentsCommandToStudents.convert(studentCommand)));

//        if(publicKeyCommand.getPrivateKeyId() != null){
//            PrivateKeys privateKeys = new PrivateKeys();
//            privateKeys.setId(publicKeyCommand.getPrivateKeyId());
//            privateKeys.addPublicKey(publicKeys);
//            //privateKeys.setPublicKeys(publicKeys);
//        }
        return publicKeys;
    }
}
