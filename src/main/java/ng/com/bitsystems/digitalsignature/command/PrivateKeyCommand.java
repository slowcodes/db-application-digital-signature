package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
public class PrivateKeyCommand {
    private Long id;
    private PublicKeyCommand publicKeyCommand;
    private LocalDate createdAt;
    private UsersCommand usersCommand;
}
