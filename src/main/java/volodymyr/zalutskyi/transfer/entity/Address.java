package volodymyr.zalutskyi.transfer.entity;

import lombok.*;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String buildingNumber;

    @OneToMany(mappedBy = "address")
    private List<Client> clients = new ArrayList<>();
}
