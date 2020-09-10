package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class ResultCommand {
    private String testScore;
    private String examScore;
    private StudentCommand studentCommand;
    private Long uploadId;
    private Long id;

    //Only required for presentation
    private String grade;
    private Double total;
    private String courseCode;
    private String courseTitle;
}

