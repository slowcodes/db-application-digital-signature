package ng.com.bitsystems.digitalsignature.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users_privileges")
public class UsersPrivileges extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users user;

    @Enumerated(value = EnumType.STRING)
    private Privileges privileges;
}
