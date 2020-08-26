package ng.com.bitsystems.digitalsignature.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Students extends Person {

    private String matricNumber;

    @ManyToOne
    @JoinColumn(name = "counties_id")
    private Counties county;

    @ManyToOne
    @JoinColumn(name = "departments_id")
    private Departments department;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<Results> results = new HashSet<>();

    @ManyToMany(mappedBy = "students")
    private Set<PublicKeys> publicKeys = new HashSet<>();

    @Builder
    public Students(String firstName, String lastName, String sex,
                    String matricNumber, Departments departments, Counties county){

        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setSex(sex);
        this.matricNumber = matricNumber;
        this.department = departments;
        this.county = county;

    }
}
