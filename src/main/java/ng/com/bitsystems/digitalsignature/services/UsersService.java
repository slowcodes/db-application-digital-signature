package ng.com.bitsystems.digitalsignature.services;

import ng.com.bitsystems.digitalsignature.command.UsersCommand;
import ng.com.bitsystems.digitalsignature.model.Users;

public interface UsersService extends CrudService<Users, Long> {

    UsersCommand findCommandById(Long l);
    UsersCommand addUserCommand(UsersCommand usersCommand);

    UsersCommand findUserCommand(UsersCommand userscommand);
}
