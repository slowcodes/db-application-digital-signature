package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.UserPrivilegeCommand;
import ng.com.bitsystems.digitalsignature.model.UsersPrivileges;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UsersPrivilegeCommandToUsersPrivilege implements Converter<UserPrivilegeCommand, UsersPrivileges> {

    private UsersCommandToUsers usersCommandToUsers;

    public UsersPrivilegeCommandToUsersPrivilege(UsersCommandToUsers usersCommandToUsers) {
        this.usersCommandToUsers = usersCommandToUsers;
    }

    @Synchronized
    @Nullable
    @Override
    public UsersPrivileges convert(UserPrivilegeCommand userPrivilegeCommand) {
        if (userPrivilegeCommand == null)
            return null;

        UsersPrivileges usersPrivileges = new UsersPrivileges();
        usersPrivileges.setPrivileges(userPrivilegeCommand.getPrivileges());
        usersPrivileges.setUser(usersCommandToUsers.convert(userPrivilegeCommand.getUsersCommand()));
        usersPrivileges.setId(usersPrivileges.getId());
        return usersPrivileges;
    }
}
