package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ng.com.bitsystems.digitalsignature.model.Privileges;


@Setter
@Getter
@NoArgsConstructor
public class PrivilegeCommand {
    private Long id;
    private Privileges privileges;
}
