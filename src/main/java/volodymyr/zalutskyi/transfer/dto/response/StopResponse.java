package volodymyr.zalutskyi.transfer.dto.response;

import lombok.Getter;
import lombok.Setter;
import volodymyr.zalutskyi.transfer.entity.Stop;


@Getter
@Setter
public class StopResponse {
    private Long id;
    private String addressStop;
    private String description;
    private Integer waitTime;



    public StopResponse(Stop stop){
        id = stop.getId();
        description = stop.getDescription();
        waitTime = stop.getWaitTime();
        addressStop = stop.getAddressStop();
    }
}
