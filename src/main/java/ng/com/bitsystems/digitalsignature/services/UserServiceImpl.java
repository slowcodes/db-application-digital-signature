package ng.com.bitsystems.digitalsignature.services;

import lombok.extern.slf4j.Slf4j;
import ng.com.bitsystems.digitalsignature.command.UsersCommand;
import ng.com.bitsystems.digitalsignature.converters.UsersCommandToUsers;
import ng.com.bitsystems.digitalsignature.converters.UsersToUsersCommand;
import ng.com.bitsystems.digitalsignature.model.Users;
import ng.com.bitsystems.digitalsignature.repository.UsersRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Primary
public class UserServiceImpl implements UsersService{
    private final UsersRepository usersRepository;
    private final UsersToUsersCommand usersToUsersCommand;
    private final UsersCommandToUsers usersCommandToUsers;

    public UserServiceImpl(UsersRepository usersRepository, UsersToUsersCommand usersToUsersCommand, UsersCommandToUsers usersCommandToUsers) {
        this.usersRepository = usersRepository;
        this.usersToUsersCommand = usersToUsersCommand;
        this.usersCommandToUsers = usersCommandToUsers;
    }

    @Override
    public Set<Users> findAll() {

        Set<Users> users = new HashSet<>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public Users findByID(Long aLong) {
        return usersRepository.findById(aLong).get();
    }

    @Override
    public Users add(Users object) {
        return usersRepository.save(object);
    }

    @Override
    public void delete(Users object) {
        usersRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        usersRepository.deleteById(aLong);
    }

    @Override
    public UsersCommand findCommandById(Long l) {
        return null;
    }

    @Override
    @Transactional
    public UsersCommand addUserCommand(UsersCommand usersCommand) {
        Users detachedUser = usersCommandToUsers.convert(usersCommand);
        Users savedUser = usersRepository.save(detachedUser);
        log.info("New user has been saved");
        return usersToUsersCommand.convert(savedUser);
    }
}
