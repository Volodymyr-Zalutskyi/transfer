package volodymyr.zalutskyi.transfer.dto.response;

import lombok.Getter;
import lombok.Setter;
import volodymyr.zalutskyi.transfer.entity.Stop;

@Getter
@Setter
public class StopResponse {
    private Long id;
    private String description;
    private Integer minWaite;
    private AddressResponse address;


    public StopResponse(Stop stop){
        id = stop.getId();
        description = stop.getDescription();
        minWaite = stop.getMinWaite();
        address = new AddressResponse(stop.getAddress());
    }
}
