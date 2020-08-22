package ng.com.bitsystems.digitalsignature.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "uploads")
public class Uploads extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users owner;

    private LocalDate uploadedOn;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses course;

    @OneToMany(mappedBy = "upload")
    private Set<Results> results = new HashSet<>();

    @OneToOne
    private PrivateKeys privateKeys;

    @OneToOne
    private PublicKeys publicKeys;
}
