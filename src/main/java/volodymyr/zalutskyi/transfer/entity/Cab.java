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
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeOfCab;
    private Float amountForOneKm;

    @OneToMany(mappedBy = "cab")
    private List<CabOrder> cabOrders = new ArrayList<>();
}
