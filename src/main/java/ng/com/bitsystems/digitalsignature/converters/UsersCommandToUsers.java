package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.UsersCommand;
import ng.com.bitsystems.digitalsignature.model.Users;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsersCommandToUsers implements Converter<UsersCommand, Users> {
    @Override
    public Users convert(UsersCommand usersCommand) {
        if(usersCommand == null)
            return null;

        Users users = new Users();
//        users.setPrivateKeys();
//        users.setPublicKeys();
//        users.setUsersPrivileges();
        users.setEmail(usersCommand.getEmail());
        users.setId(usersCommand.getId());
        users.setPassword(users.getPassword());
        users.setUsername(users.getUsername());
        return users;
    }
}
