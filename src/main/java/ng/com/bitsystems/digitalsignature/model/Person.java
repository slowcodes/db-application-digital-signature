package ng.com.bitsystems.digitalsignature.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {
    //@Column(name = "first_name")
    private String firstName;

    //@Column(name = "last_name")
    private String lastName;

    private String sex;

    public Person(Long id, String firstName, String lastName, String sex){
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }
}
