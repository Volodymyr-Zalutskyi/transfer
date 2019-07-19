package volodymyr.zalutskyi.transfer.dto.response;

import lombok.Getter;
import lombok.Setter;
import volodymyr.zalutskyi.transfer.entity.Cab;

@Getter
@Setter
public class CabResponse {
    private Long id;
    private String typeOfCab;
    private Float amountForOneKm;


    public CabResponse(Cab cab){
        id = cab.getId();
        typeOfCab = cab.getTypeOfCab();
        amountForOneKm = cab.getAmountForOneKm();
    }
}
