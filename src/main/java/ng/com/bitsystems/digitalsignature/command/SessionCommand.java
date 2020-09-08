package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
public class SessionCommand {
    private Long id;
    private String session;
    private Set<ResultCommand> resultCommands = new HashSet<>();
}
