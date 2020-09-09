package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
public class PublicKeyCommand {
    private Long id;
    private String publicKey;
    private Set<StudentCommand> studentCommands = new HashSet<>();
    private Set<UsersCommand> usersCommands = new HashSet<>();
}
