package ng.com.bitsystems.digitalsignature.services;

import ng.com.bitsystems.digitalsignature.command.PublicKeyCommand;
import ng.com.bitsystems.digitalsignature.model.PublicKeys;

public interface PublicKeysService extends CrudService<PublicKeys, Long> {
    PublicKeyCommand add(PublicKeyCommand publicKeyCommand);
}
