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


    @ManyToMany
    @JoinTable(name = "users_publickeys",
            joinColumns = @JoinColumn(name = "publickeys_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<Users> users = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "student_publickeys",
            joinColumns = @JoinColumn(name = "publickeys_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Students> students = new HashSet<>();

    private LocalDate createdAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicKey")
    private Set<Results> results = new HashSet<>();
}
