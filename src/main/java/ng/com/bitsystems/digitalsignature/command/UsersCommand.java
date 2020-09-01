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
    private String username;
}