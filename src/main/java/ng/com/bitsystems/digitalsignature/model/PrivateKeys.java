package ng.com.bitsystems.digitalsignature.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PrivateKeys extends BaseEntity {
    private String passphrase;
    private String privateKey;

    @OneToOne
    private PublicKeys publicKeys;

    private LocalDate createdAt;

    @OneToOne
    private Uploads uploads;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
}
