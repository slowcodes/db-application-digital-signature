package ng.com.bitsystems.digitalsignature.command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class UploadCommand {
    private Long id;
    private LocalDate dateOfUpload;
    private UsersCommand usersCommand;
    private CoursesCommand coursesCommand;
    private SessionCommand sessionCommand;
    private Set<ResultCommand> resultCommand = new HashSet<>();
    private PrivateKeyCommand privateKeyCommand;
}