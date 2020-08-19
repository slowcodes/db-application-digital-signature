package ng.com.bitsystems.digitalsignature.command;

import java.util.HashSet;
import java.util.Set;

public class UsersCommand {
    private Long id;
    private String firstName;
    private String lastName;
    private String sex;
    private Set<UserPrivilegeCommand> userPrivilegeCommands = new HashSet<>();
    private Set<PrivateKeyCommand> privateKeyCommands = new HashSet<>();
    private Set<PublicKeyCommand> publicKeyCommands = new HashSet<>();
}
