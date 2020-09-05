package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.PrivateKeyCommand;
import ng.com.bitsystems.digitalsignature.model.PrivateKeys;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PrivateKeysToPrivateKeysCommand implements Converter<PrivateKeys, PrivateKeyCommand> {

    private UsersToUsersCommand usersToUsersCommand;
    private PublicKeysToPublicKeysCommand publicKeysToPublicKeysCommand;

    public PrivateKeysToPrivateKeysCommand(UsersToUsersCommand usersToUsersCommand,
                                           PublicKeysToPublicKeysCommand publicKeysToPublicKeysCommand) {
        this.usersToUsersCommand = usersToUsersCommand;
        this.publicKeysToPublicKeysCommand = publicKeysToPublicKeysCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public PrivateKeyCommand convert(PrivateKeys privateKeys) {
        if(privateKeys == null){
            return null;
        }
        PrivateKeyCommand privateKeyCommand = new PrivateKeyCommand();
        privateKeyCommand.setCreatedAt(privateKeys.getCreatedAt());
        privateKeyCommand.setUsersCommand(usersToUsersCommand.convert(privateKeys.getUsers()));
        privateKeyCommand.setPrivateKey(privateKeys.getPrivateKey());
        privateKeyCommand.setPassphrase(privateKeys.getPassphrase());
       // privateKeyCommand.setPublicKeyCommand(publicKeysToPublicKeysCommand.convert(privateKeys.getPublicKeys()));
        privateKeyCommand.setUsersCommand(usersToUsersCommand.convert(privateKeys.getUsers()));
        return privateKeyCommand;
    }
}
