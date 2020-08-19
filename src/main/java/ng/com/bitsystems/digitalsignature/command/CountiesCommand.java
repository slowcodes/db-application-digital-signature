package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class CountiesCommand {
    private Long id;
    private String lga;
    private StateCommand stateCommand;
    private Set<StudentCommand> studentCommand = new HashSet<>();
}
