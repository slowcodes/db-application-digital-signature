package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.PrivateKeyCommand;
import ng.com.bitsystems.digitalsignature.model.PrivateKeys;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PrivateKeysCommandToPrivateKeys implements Converter<PrivateKeyCommand, PrivateKeys> {

    @Override
    public PrivateKeys convert(PrivateKeyCommand privateKeyCommand) {
        if(privateKeyCommand == null){
            return null;
        }
        PrivateKeys privateKeys = new PrivateKeys();
        privateKeys.setId(privateKeyCommand.getId());
        privateKeys.setCreatedAt(privateKeyCommand.getCreatedAt());
        //privateKeys.setPassphrase(privateKeyCommand.getPublicKeyCommand().getPassphrase());
        return privateKeys;
    }

}
