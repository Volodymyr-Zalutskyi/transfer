package volodymyr.zalutskyi.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volodymyr.zalutskyi.transfer.dto.request.AddressRequest;
import volodymyr.zalutskyi.transfer.dto.response.AddressResponse;
import volodymyr.zalutskyi.transfer.service.AddressService;

import javax.validation.Valid;
import java.util.List;

import static volodymyr.zalutskyi.transfer.tool.Constants.ADDRESS_URL;

@RestController
@RequestMapping(ADDRESS_URL)
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public void create(@Valid @RequestBody AddressRequest request){
        addressService.create(request);
    }

    @GetMapping
    public List<AddressResponse> findAll(){
       return addressService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody AddressRequest request){
        addressService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id){
        addressService.delete(id);
    }
}
