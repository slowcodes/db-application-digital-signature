package ng.com.bitsystems.digitalsignature.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Courses extends BaseEntity {

    private String courseCode;
    private String courseTitle;
    private Integer credits;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments serviceDepartment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Set<Results> results = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Set<Uploads> uploads = new HashSet<>();

    @Builder
    public Courses(Long id, String courseCode, String courseTitle, Integer credits, Departments serviceDepartment){
        super(id);
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.credits = credits;
        this.serviceDepartment = serviceDepartment;
    }


    @Builder
    public Courses(String courseCode, String courseTitle, Integer credits, Departments serviceDepartment){
        super();
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.credits = credits;
        this.serviceDepartment = serviceDepartment;
    }

    public Courses addResult(Results results) {
        results.setCourse(this);
        this.results.add(results);
        return this;
    }
}
