package ng.com.bitsystems.digitalsignature.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "counties")
public class Counties extends BaseEntity {

    private String lga;

    @ManyToOne
    @JoinColumn(name = "states_id")
    private States state;

//    @OneToMany(mappedBy = "county")
//    private Set<Students> students = new HashSet<>();
}
