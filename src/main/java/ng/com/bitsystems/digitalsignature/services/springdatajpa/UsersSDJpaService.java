package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.command.UsersCommand;
import ng.com.bitsystems.digitalsignature.model.Users;
import ng.com.bitsystems.digitalsignature.repository.UsersRepository;
import ng.com.bitsystems.digitalsignature.services.UsersService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsersSDJpaService implements UsersService {
    private UsersRepository usersRepository;

    @Override
    public UsersCommand findCommandById(Long l) {
        return null;
    }

    @Override
    public UsersCommand addUserCommand(UsersCommand usersCommand) {
        return null;
    }

    @Override
    public UsersCommand findUserCommand(UsersCommand userscommand) {
        return null;
    }

    public UsersSDJpaService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
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
}
