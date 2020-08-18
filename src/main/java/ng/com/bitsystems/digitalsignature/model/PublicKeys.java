package ng.com.bitsystems.digitalsignature.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PublicKeys extends BaseEntity{
    private String passphrase;
    private String publickey;


    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users owner;

    private LocalDate createdAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "key")
    private Set<Results> results = new HashSet<>();
}
