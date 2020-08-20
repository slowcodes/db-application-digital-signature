package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.UsersCommand;
import ng.com.bitsystems.digitalsignature.model.Users;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsersToUsersCommand implements Converter<Users, UsersCommand> {
    @Override
    public UsersCommand convert(Users users) {
        if(users == null)
            return null;

        UsersCommand usersCommand = new UsersCommand();
        usersCommand.setEmail(users.getEmail());
        usersCommand.setFirstName(users.getFirstName());
        usersCommand.setLastName(users.getLastName());
        //usersCommand.setPrivateKeyCommands();
        //usersCommand.setPublicKeyCommands();
        usersCommand.setSex(users.getSex());
        //usersCommand.setUserPrivilegeCommands();
        return usersCommand;
    }
}
