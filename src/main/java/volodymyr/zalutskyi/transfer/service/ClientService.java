package volodymyr.zalutskyi.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volodymyr.zalutskyi.transfer.dto.request.ClientRequest;
import volodymyr.zalutskyi.transfer.dto.response.ClientResponse;
import volodymyr.zalutskyi.transfer.entity.Client;
import volodymyr.zalutskyi.transfer.repository.ClientRepositiry;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepositiry clientRepositiry;

    @Autowired
    private AddressService addressService;


    public void create(ClientRequest request){
       clientRepositiry.save(clientRequestToClient(null, request));
    }

    public List<ClientResponse> findAll(){
        return clientRepositiry.findAll().stream().map(ClientResponse::new).collect(Collectors.toList());
    }

    public Client findOne(Long id){
        return clientRepositiry.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Client with id "+ id + " not exist"));
    }

    public void update(long id, ClientRequest request){
        clientRepositiry.save(clientRequestToClient(findOne(id), request));
    }

    public void delete(Long id){
        clientRepositiry.delete(findOne(id));
    }

    private Client clientRequestToClient(Client client, ClientRequest request){
        if(client == null){
            client = new Client();
        }
        client.setAddress(addressService.findOne(request.getAddressId()));
        client.setCompany(request.getCompany());
        return client;
    }

}
