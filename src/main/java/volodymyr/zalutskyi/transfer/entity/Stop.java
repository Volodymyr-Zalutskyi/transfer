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
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer minWaite;
    @OneToOne
    private Address address;

    @ManyToMany(mappedBy = "stops")
    private List<CabOrder> cabOrders = new ArrayList<>();
}
