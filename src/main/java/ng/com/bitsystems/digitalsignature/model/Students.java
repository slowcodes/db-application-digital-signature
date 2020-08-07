package ng.com.bitsystems.digitalsignature.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "students")
    private Counties county;

    @ManyToOne
    @JoinColumn(name = "departments_id")
    private Departments department;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<Results> results = new HashSet<>();
}
