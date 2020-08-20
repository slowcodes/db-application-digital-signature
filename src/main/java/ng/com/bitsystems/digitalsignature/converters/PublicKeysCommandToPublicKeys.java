package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.PublicKeyCommand;
import ng.com.bitsystems.digitalsignature.model.PublicKeys;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PublicKeysCommandToPublicKeys implements Converter<PublicKeyCommand, PublicKeys> {


    @Override
    public PublicKeys convert(PublicKeyCommand publicKeyCommand) {
        if(publicKeyCommand == null){
            return null;
        }

        PublicKeys publicKeys = new PublicKeys();
        publicKeys.setCreatedAt(publicKeyCommand.getCreatedAt());
        publicKeys.setPublickey(publicKeyCommand.getPublicKey());
        //publicKeys.setResults();
        //publicKeys.setUsers();
        return publicKeys;
    }
}
