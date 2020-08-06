package ng.com.bitsystems.digitalsignature.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Departments extends BaseEntity {

    private String department;

    @ManyToOne
    @JoinColumn(name = "faculties_id")
    private Faculties faculties;
}
