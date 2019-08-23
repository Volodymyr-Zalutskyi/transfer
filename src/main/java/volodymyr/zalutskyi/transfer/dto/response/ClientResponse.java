package volodymyr.zalutskyi.transfer.dto.response;

import lombok.Getter;
import lombok.Setter;
import volodymyr.zalutskyi.transfer.entity.Client;


@Getter
@Setter
public class ClientResponse {
    private Long id;
    private String company;
    private AddressResponse address;

    public ClientResponse(Client client){
       id = client.getId();
       company = client.getCompany();
       address = new AddressResponse(client.getAddress());
    }
}
