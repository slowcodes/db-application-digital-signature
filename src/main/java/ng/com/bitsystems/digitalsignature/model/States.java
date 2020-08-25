package ng.com.bitsystems.digitalsignature.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "states")
public class States extends BaseEntity{
    private String state;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
    private Set<Counties> lgas = new HashSet<>();

    public States addCounties(Counties counties){
        counties.setState(this);
        this.lgas.add(counties);
        return this;
    }
}
