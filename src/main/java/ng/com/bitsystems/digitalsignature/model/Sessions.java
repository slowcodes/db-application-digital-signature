package ng.com.bitsystems.digitalsignature.model;

import lombok.*;

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
public class Sessions extends BaseEntity {

    private String session;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
    private Set<Results> results = new HashSet<>();

    @Builder
    public Sessions(Long id, String session){
        super(id);
        this.session = session;
    }

    public Sessions addResult(Results results) {
        results.setSession(this);
        this.results.add(results);
        return this;
    }
}
