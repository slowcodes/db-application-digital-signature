package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UsersCommand {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String sex;
    private String password;
//    private Set<UserPrivilegeCommand> userPrivilegeCommands = new HashSet<>();
//    private Set<UploadCommand> uploadCommands = new HashSet<>();
//    private Set<PublicKeyCommand> publicKeyCommands = new HashSet<>();
//    private Set<UsersCommand> usersCommands = new HashSet<>();
}