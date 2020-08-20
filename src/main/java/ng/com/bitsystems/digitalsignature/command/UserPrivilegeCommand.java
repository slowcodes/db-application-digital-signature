package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserPrivilegeCommand {
    private Long id;
    private UsersCommand usersCommand;
    private PrivilegeCommand privileges;
}
