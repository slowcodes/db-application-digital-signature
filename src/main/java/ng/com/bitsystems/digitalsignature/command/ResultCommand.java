package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class ResultCommand {
    private Long id;
    private Double testScore;
    private Double examScore;
    private Character grade;
    private Double totalScore;
    private StudentCommand studentCommand;
    private SessionCommand sessionCommand;
    private CoursesCommand coursesCommand;
    private UploadCommand uploadCommand;
}

