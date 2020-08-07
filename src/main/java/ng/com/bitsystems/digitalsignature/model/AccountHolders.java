package ng.com.bitsystems.digitalsignature.model;


import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class AccountHolders extends BaseEntity {

    private String username;
    private String password;
    private String email;

    @Builder
    public AccountHolders(Long id, String username, String password, String email){
        super(id);
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
