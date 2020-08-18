package ng.com.bitsystems.digitalsignature.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users extends AccountHolders {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<UsersPrivileges> usersPrivileges = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<PublicKeys> keys = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "publicKeys_id")
    private PublicKeys publicKeys;
}
