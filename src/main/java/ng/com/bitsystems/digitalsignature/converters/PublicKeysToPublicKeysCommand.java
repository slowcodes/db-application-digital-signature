package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.PublicKeyCommand;
import ng.com.bitsystems.digitalsignature.model.PublicKeys;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PublicKeysToPublicKeysCommand implements Converter<PublicKeys, PublicKeyCommand> {


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
        //publicKeyCommand.setPrivateKeyCommand(privateKeysToPrivateKeysCommand.convert(publicKeys.getPrivateKeys()));

        if(publicKeys.getPrivateKeys() != null){
            publicKeyCommand.setPrivateKeyId(publicKeys.getPrivateKeys().getId());
        }

        return publicKeyCommand;
    }
}
