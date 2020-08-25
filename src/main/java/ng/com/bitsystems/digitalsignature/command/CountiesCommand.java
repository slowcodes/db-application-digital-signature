package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CountiesCommand {
    private Long id;
    private String lga;
    private StateCommand stateCommand;
    private Long stateId;
//    private Set<StudentCommand> studentCommand = new HashSet<>();
}
