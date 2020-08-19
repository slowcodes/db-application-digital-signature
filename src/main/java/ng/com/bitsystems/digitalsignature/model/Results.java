package ng.com.bitsystems.digitalsignature.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Results extends BaseEntity {

    private Double testScore;
    private Double examScore;
    private Character grade;
    private Double totalScore;

    @ManyToOne
    @JoinColumn(name = "students_id")
    private Students student;

    @ManyToOne
    @JoinColumn(name = "sessions_id")
    private Sessions session;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses course;


    @ManyToOne
    @JoinColumn(name = "uploads_id")
    private Uploads upload;


    @Builder
    public Results(Long id, Students students, Sessions session, Courses course, Double testScore, Double examScore ){
        super(id);
        this.student = students;
        this.course = course;
        this.session = session;
        this.totalScore = testScore + examScore;
    }
}
