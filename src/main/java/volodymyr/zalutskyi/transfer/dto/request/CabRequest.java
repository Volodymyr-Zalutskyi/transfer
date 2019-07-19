package volodymyr.zalutskyi.transfer.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


@Getter
@Setter
public class CabRequest {
    @NotBlank
    private String typeOfCab;
    @Positive
    private Float amountForOneKm;
}
