package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.model.UsersPrivileges;
import ng.com.bitsystems.digitalsignature.repository.UsersPrivilegeRepository;
import ng.com.bitsystems.digitalsignature.services.UsersPrivilegesService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserPrivilegeSDJpaService implements UsersPrivilegesService {
    private UsersPrivilegeRepository usersPrivilegeRepository;

    public UserPrivilegeSDJpaService(UsersPrivilegeRepository usersPrivilegeRepository) {
        this.usersPrivilegeRepository = usersPrivilegeRepository;
    }

    @Override
    public Set<UsersPrivileges> findAll() {
        Set<UsersPrivileges> usersPrivileges = new HashSet<>();
        usersPrivilegeRepository.findAll().forEach(usersPrivileges::add);
        return usersPrivileges;
    }

    @Override
    public UsersPrivileges findByID(Long aLong) {
        return usersPrivilegeRepository.findById(aLong).get();
    }

    @Override
    public UsersPrivileges add(UsersPrivileges object) {
        return usersPrivilegeRepository.save(object);
    }

    @Override
    public void delete(UsersPrivileges object) {
        usersPrivilegeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        usersPrivilegeRepository.deleteById(aLong);
    }
}
