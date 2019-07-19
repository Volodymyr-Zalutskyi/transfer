package volodymyr.zalutskyi.transfer.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    private String street;
    private String bildingNumber;

    @OneToOne(mappedBy = "address")
    private Stop stops ;

    @OneToOne(mappedBy = "address")
    private Client client;
}
