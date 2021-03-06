package volodymyr.zalutskyi.transfer.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddressRequest {
    @NotBlank
    private String city;
    @NotBlank
    private String street;
    @NotBlank
    private String buildingNumber;
}
