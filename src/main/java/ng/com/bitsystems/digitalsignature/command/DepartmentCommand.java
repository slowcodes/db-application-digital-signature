package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
public class DepartmentCommand {
    private Long id;
    private String department;
    private Long facultiesId;
    private Set<CoursesCommand> coursesCommand = new HashSet<>();
    private Set<StudentCommand> studentCommands = new HashSet<>();
    private FacultiesCommand facultiesCommand;
}
