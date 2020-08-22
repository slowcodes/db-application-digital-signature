package ng.com.bitsystems.digitalsignature.converters;

import lombok.Synchronized;
import ng.com.bitsystems.digitalsignature.command.UserPrivilegeCommand;
import ng.com.bitsystems.digitalsignature.model.UsersPrivileges;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UsersPrivilegeToUsersPrivilegeCommand implements Converter<UsersPrivileges, UserPrivilegeCommand> {
    private UsersToUsersCommand usersToUsersCommand;

    public UsersPrivilegeToUsersPrivilegeCommand(UsersToUsersCommand usersToUsersCommand) {
        this.usersToUsersCommand = usersToUsersCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public UserPrivilegeCommand convert(UsersPrivileges usersPrivileges) {
        if(usersPrivileges == null)
            return null;

        UserPrivilegeCommand userPrivilegeCommand = new UserPrivilegeCommand();
        userPrivilegeCommand.setId(usersPrivileges.getId());
        userPrivilegeCommand.setPrivileges(usersPrivileges.getPrivileges());
        userPrivilegeCommand.setUsersCommand(usersToUsersCommand.convert(usersPrivileges.getUser()));

        return userPrivilegeCommand;
    }
}
