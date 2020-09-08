package ng.com.bitsystems.digitalsignature.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class ResultCommand {
    private Double testScore;
    private Double examScore;
    private StudentCommand studentCommand;
    private Long uploadId;
    private Long id;
}

