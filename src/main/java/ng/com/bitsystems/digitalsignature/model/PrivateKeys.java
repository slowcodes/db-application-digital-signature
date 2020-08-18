package ng.com.bitsystems.digitalsignature.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
public class PrivateKeys extends BaseEntity {
    private String passphrase;
    private String privateKey;

    @OneToOne
    private PublicKeys owner;

    private LocalDate createdAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "key")
    private Set<Users> users = new HashSet<>();
}
