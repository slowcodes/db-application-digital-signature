package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.PublicKeyCommand;
import ng.com.bitsystems.digitalsignature.model.PublicKeys;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PublicKeysToPublicKeysCommand implements Converter<PublicKeys, PublicKeyCommand> {
    @Override
    public PublicKeyCommand convert(PublicKeys publicKeys) {
        if(publicKeys == null){
            return null;
        }

        PublicKeyCommand publicKeyCommand = new PublicKeyCommand();
        publicKeyCommand.setCreatedAt(publicKeys.getCreatedAt());
        publicKeyCommand.setId(publicKeys.getId());
        //publicKeyCommand.setPublicKey(publicKeys.setPublickey());
        //publicKeyCommand.setResultCommands();
        //publicKeyCommand.setUsersCommands();
        //publicKeyCommand.setUsersCommands();
        return publicKeyCommand;
    }
}
