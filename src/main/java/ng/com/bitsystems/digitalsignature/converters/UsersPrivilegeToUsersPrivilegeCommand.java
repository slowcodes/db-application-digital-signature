package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.UserPrivilegeCommand;
import ng.com.bitsystems.digitalsignature.model.UsersPrivileges;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsersPrivilegeToUsersPrivilegeCommand implements Converter<UsersPrivileges, UserPrivilegeCommand> {
    @Override
    public UserPrivilegeCommand convert(UsersPrivileges usersPrivileges) {
        if(usersPrivileges == null)
            return null;

        UserPrivilegeCommand userPrivilegeCommand = new UserPrivilegeCommand();
        userPrivilegeCommand.setId(usersPrivileges.getId());
        //userPrivilegeCommand.setPrivileges();
        //userPrivilegeCommand.setUsersCommand();
        return userPrivilegeCommand;
    }
}
