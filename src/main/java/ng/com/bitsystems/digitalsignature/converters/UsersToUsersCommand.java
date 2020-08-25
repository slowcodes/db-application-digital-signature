package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.UsersCommand;
import ng.com.bitsystems.digitalsignature.model.Users;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UsersToUsersCommand implements Converter<Users, UsersCommand> {


    @Synchronized
    @Nullable
    @Override
    public UsersCommand convert(Users users) {
        if(users == null)
            return null;

        UsersCommand usersCommand = new UsersCommand();
        usersCommand.setEmail(users.getEmail());
        usersCommand.setFirstName(users.getFirstName());
        usersCommand.setLastName(users.getLastName());


//        if(users.getUsersPrivileges().size()>0 && users.getUsersPrivileges() != null)
//            users.getUsersPrivileges().forEach(usersPrivileges -> usersCommand.getUserPrivilegeCommands().add(usersPrivilegeToUsersPrivilegeCommand.convert(usersPrivileges)));

        usersCommand.setSex(users.getSex());
        usersCommand.setId(users.getId());

        return usersCommand;
    }
}
