package volodymyr.zalutskyi.transfer.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class ClientRequest {
    @NotBlank
    private String company;
    @NotNull
    private Long addressId;
}
