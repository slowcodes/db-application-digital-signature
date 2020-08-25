package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;



@Setter
@Getter
@NoArgsConstructor
public class CoursesCommand {
    private Long id;
    private String courseCode;
    private String courseTitle;
    private Integer credits;
    private Long departmentId;
    private Set<ResultCommand> resultCommand = new HashSet<>();
    private Set<UploadCommand> uploadCommands = new HashSet<>();
    private Set<StudentCommand> studentCommands = new HashSet<>();
}
