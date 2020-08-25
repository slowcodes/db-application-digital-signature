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
@Table(name = "departments")
public class Departments extends BaseEntity {

    private String department;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceDepartment")
    private Set<Courses> courses = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "faculties_id")
    private Faculties faculty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Set<Students> students = new HashSet<>();

    @Builder
    public Departments(Long id, String department, Faculties faculty, Set<Courses> courses){
        super(id);
        this.department = department;
        this.faculty = faculty;
        if(courses != null){
            this.courses = courses;
        }
    }

    public Departments addCourse(Courses courses) {
        courses.setServiceDepartment(this);
        this.courses.add(courses);
        return this;
    }
}
