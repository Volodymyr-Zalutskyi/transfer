package volodymyr.zalutskyi.transfer.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class StopRequest {
    @NotNull
    private String addressStop;
    @NotNull
    private String description;
    @Positive
    @NotNull
    private Integer waitTime;
}
