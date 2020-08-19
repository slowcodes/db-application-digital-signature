package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
public class FacultiesCommand {
    private Long id;
    private String faculty;
    private Set<DepartmentCommand> departmentCommands = new HashSet<>();
}
