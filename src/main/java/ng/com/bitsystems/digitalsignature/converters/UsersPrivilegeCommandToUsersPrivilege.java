package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.UserPrivilegeCommand;
import ng.com.bitsystems.digitalsignature.model.UsersPrivileges;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsersPrivilegeCommandToUsersPrivilege implements Converter<UserPrivilegeCommand, UsersPrivileges> {
    @Override
    public UsersPrivileges convert(UserPrivilegeCommand userPrivilegeCommand) {
        if (userPrivilegeCommand == null)
            return null;

        UsersPrivileges usersPrivileges = new UsersPrivileges();
        //usersPrivileges.setPrivileges();
        //usersPrivileges.setUser(userPrivilegeCommand.getCommand());
        usersPrivileges.setId(usersPrivileges.getId());
        return usersPrivileges;
    }
}
