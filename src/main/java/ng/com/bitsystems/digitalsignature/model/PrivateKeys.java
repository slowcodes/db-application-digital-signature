package ng.com.bitsystems.digitalsignature.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PrivateKeys extends BaseEntity {
    private String passphrase;
    private String privateKey;

    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @OneToOne(cascade = CascadeType.ALL)
    private PublicKeys publicKeys;

//    public PrivateKeys addPublicKey(PublicKeys publicKeys) {
//        publicKeys.setPrivateKeys(this);
//        //this.setPublicKeys(publicKeys);
//        return this;
//    }

    public void setPublicKey(PublicKeys publicKey){
        if(publicKey != null){
            this.publicKeys = publicKey;
            publicKey.setPrivateKeys(this);
        }
    }
}
