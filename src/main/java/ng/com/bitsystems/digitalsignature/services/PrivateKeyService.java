package ng.com.bitsystems.digitalsignature.services;


import ng.com.bitsystems.digitalsignature.command.PrivateKeyCommand;
import ng.com.bitsystems.digitalsignature.model.PrivateKeys;

public interface PrivateKeyService extends CrudService<PrivateKeys, Long> {
    PrivateKeyCommand add(PrivateKeyCommand privateKeyCommand);

    PrivateKeyCommand findCommandByID(Long id);
}
