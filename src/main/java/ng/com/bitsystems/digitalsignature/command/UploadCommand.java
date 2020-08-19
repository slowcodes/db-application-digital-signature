package ng.com.bitsystems.digitalsignature.command;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class UploadCommand {
    private Long id;
    private LocalDate dateOfUpload;
    private UsersCommand usersCommand;
    private CoursesCommand coursesCommand;
    private Set<ResultCommand> resultCommand = new HashSet<>();
    private PrivateKeyCommand privateKeyCommand;
}