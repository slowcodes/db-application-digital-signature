package ng.com.bitsystems.digitalsignature.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Faculties extends BaseEntity {
    private String faculty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty")
    private Set<Departments> departments = new HashSet<>();
}
