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
    private String addressStop;
    private String description;
    private Integer waitTime;




    @ManyToOne
    private CabOrder cabOrder;
}
