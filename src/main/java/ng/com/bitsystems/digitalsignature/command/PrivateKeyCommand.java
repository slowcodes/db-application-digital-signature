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
    private LocalDate createdAt;
    private String privateKey;
    private String passphrase;
    private UsersCommand usersCommand;
    public PublicKeyCommand publicKeyCommand;
}
