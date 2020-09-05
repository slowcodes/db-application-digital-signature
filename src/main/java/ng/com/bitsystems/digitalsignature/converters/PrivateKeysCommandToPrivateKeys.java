package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.PrivateKeyCommand;
import ng.com.bitsystems.digitalsignature.model.PrivateKeys;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PrivateKeysCommandToPrivateKeys implements Converter<PrivateKeyCommand, PrivateKeys> {

    private UsersCommandToUsers usersCommandToUsers;

    public PrivateKeysCommandToPrivateKeys(UsersCommandToUsers usersCommandToUsers) {
        this.usersCommandToUsers = usersCommandToUsers;
    }

    @Synchronized
    @Nullable
    @Override
    public PrivateKeys convert(PrivateKeyCommand privateKeyCommand) {
        if(privateKeyCommand == null){
            return null;
        }
        PrivateKeys privateKeys = new PrivateKeys();
        privateKeys.setId(privateKeyCommand.getId());
        privateKeys.setCreatedAt(privateKeyCommand.getCreatedAt());
        privateKeys.setPassphrase(privateKeyCommand.getPassphrase());
        privateKeys.setPrivateKey(privateKeyCommand.getPrivateKey());
        privateKeys.setUsers(usersCommandToUsers.convert(privateKeyCommand.getUsersCommand()));
        return privateKeys;
    }

}
