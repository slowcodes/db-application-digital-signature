package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.command.PrivateKeyCommand;
import ng.com.bitsystems.digitalsignature.command.UsersCommand;
import ng.com.bitsystems.digitalsignature.converters.PrivateKeysCommandToPrivateKeys;
import ng.com.bitsystems.digitalsignature.converters.PrivateKeysToPrivateKeysCommand;
import ng.com.bitsystems.digitalsignature.model.PrivateKeys;
import ng.com.bitsystems.digitalsignature.repository.PrivateKeyRepository;
import ng.com.bitsystems.digitalsignature.services.PrivateKeyService;
import ng.com.bitsystems.digitalsignature.services.UsersService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PrivateKeySDJpaService implements PrivateKeyService {
    private PrivateKeyRepository privateKeyRepository;
    private PrivateKeysCommandToPrivateKeys privateKeysCommandToPrivateKeys;
    private PrivateKeysToPrivateKeysCommand privateKeysToPrivateKeysCommand;
    private UsersService usersService;

    public PrivateKeySDJpaService(PrivateKeyRepository privateKeyRepository, UsersService usersService,
                                  PrivateKeysCommandToPrivateKeys privateKeysCommandToPrivateKeys,
                                  PrivateKeysToPrivateKeysCommand privateKeysToPrivateKeysCommand) {
        this.privateKeyRepository = privateKeyRepository;
        this.usersService = usersService;
        this.privateKeysCommandToPrivateKeys=privateKeysCommandToPrivateKeys;
        this.privateKeysToPrivateKeysCommand=privateKeysToPrivateKeysCommand;
    }

    @Override
    public Set<PrivateKeys> findAll() {
        Set<PrivateKeys> privateKeys = new HashSet<>();
        privateKeyRepository.findAll().forEach(privateKeys::add);
        return privateKeys;
    }

    @Override
    public PrivateKeys findByID(Long aLong) {
        return privateKeyRepository.findById(aLong).get();
    }

    @Override
    public PrivateKeys add(PrivateKeys object) {
        return privateKeyRepository.save(object);
    }

    @Override
    public void delete(PrivateKeys object) {
        privateKeyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        privateKeyRepository.deleteById(aLong);
    }

    @Override
    public PrivateKeyCommand add(PrivateKeyCommand privateKeyCommand) {
        UsersCommand usersCommand = usersService.findCommandById(new Long(1));
        privateKeyCommand.setUsersCommand(usersCommand);
        PrivateKeys privateKeys = privateKeysCommandToPrivateKeys.convert(privateKeyCommand);
        PrivateKeys savedKey = privateKeyRepository.save(privateKeys);
        return privateKeysToPrivateKeysCommand.convert(savedKey);
    }

    @Override
    public PrivateKeyCommand findCommandByID(Long id) {
        return privateKeysToPrivateKeysCommand.convert(privateKeyRepository.findById(id).get());
    }
}
