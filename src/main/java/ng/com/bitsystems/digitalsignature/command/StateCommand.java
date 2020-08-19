package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
public class StateCommand {
    private Long id;
    private String state;
    private Set<CountiesCommand> countiesCommand = new HashSet<>();
}
