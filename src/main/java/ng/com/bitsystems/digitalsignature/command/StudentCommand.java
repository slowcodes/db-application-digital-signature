package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
public class StudentCommand {
    private String firstName;
    private String lastName;
    private String sex;
    private String matricNumber;
    private CountiesCommand countiesCommand;
    private DepartmentCommand departmentCommand;
    private Set<ResultCommand> resultCommands = new HashSet<>();
    private Set<PublicKeyCommand> publicKeyCommands = new HashSet<>();
}
