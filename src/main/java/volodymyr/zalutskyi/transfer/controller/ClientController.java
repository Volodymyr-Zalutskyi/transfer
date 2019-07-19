package volodymyr.zalutskyi.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volodymyr.zalutskyi.transfer.dto.request.ClientRequest;
import volodymyr.zalutskyi.transfer.dto.response.ClientResponse;
import volodymyr.zalutskyi.transfer.service.ClientService;

import javax.validation.Valid;
import java.util.List;

import static volodymyr.zalutskyi.transfer.tool.Constants.CLIENT_URL;

@RestController
@RequestMapping(CLIENT_URL)
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public void creat(@Valid @RequestBody ClientRequest request){
        clientService.create(request);
    }

    @GetMapping
    public List<ClientResponse> findAll(){
        return clientService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody ClientRequest request){
        clientService.update(id, request);
    }

    @DeleteMapping
    public void delete(long id){
        clientService.delete(id);
    }
}
