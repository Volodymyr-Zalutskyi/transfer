package volodymyr.zalutskyi.transfer.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;


    @ManyToOne
    private Address address;

    @OneToMany(mappedBy = "client")
    private List<CabOrder> cabOrders = new ArrayList<>();

}
