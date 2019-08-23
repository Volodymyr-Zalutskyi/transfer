package volodymyr.zalutskyi.transfer.dto.response;

import lombok.Getter;
import lombok.Setter;
import volodymyr.zalutskyi.transfer.entity.Address;

@Getter
@Setter
public class AddressResponse {
    private Long id;
    private String city;
    private String street;
    private String buildingNumber;

    public AddressResponse (Address address){
        id = address.getId();
        city = address.getCity();
        street = address.getStreet();
        buildingNumber = address.getBuildingNumber();
    }
}
