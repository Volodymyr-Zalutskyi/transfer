package volodymyr.zalutskyi.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volodymyr.zalutskyi.transfer.dto.request.AddressRequest;
import volodymyr.zalutskyi.transfer.dto.response.AddressResponse;
import volodymyr.zalutskyi.transfer.entity.Address;
import volodymyr.zalutskyi.transfer.repository.AddressRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void create(AddressRequest request){
        addressRepository.save(addressRequestToAddress(null, request));
    }

    public List<AddressResponse> findAll(){
        return addressRepository.findAll().stream().map(AddressResponse::new).collect(Collectors.toList());
    }

    public Address findOne(Long id){
        return addressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Address with id " + id + " not exists"));
    }

    public void update(long id, AddressRequest request){
        addressRepository.save(addressRequestToAddress(findOne(id), request));
    }

    public void delete(Long id){
      Address address = findOne(id);
      addressRepository.delete(address);
    }

    private Address addressRequestToAddress(Address address, AddressRequest request){
        if(address == null){
            address = new Address();
        }
        address.setCity(request.getCity());
        address.setStreet(request.getStreet());
        address.setBuildingNumber(request.getBuildingNumber());
        return address;
    }
}
