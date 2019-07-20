package volodymyr.zalutskyi.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volodymyr.zalutskyi.transfer.dto.request.StopRequest;
import volodymyr.zalutskyi.transfer.dto.response.StopResponse;
import volodymyr.zalutskyi.transfer.entity.Stop;
import volodymyr.zalutskyi.transfer.repository.StopRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StopServiсe {

    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private AddressService addressService;


    public void create(StopRequest request){
        stopRepository.save(stopRequestToStop(null, request));
    }

    public List<StopResponse> findAll(){
        return stopRepository.findAll()
                .stream()
                .map(StopResponse::new)
                .collect(Collectors.toList());
    }

    public Stop findOne(long id){
        return stopRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Stop with id "+ id + " not exist"));
    }

    public void update(Long id, StopRequest request){
        stopRepository.save(stopRequestToStop(findOne(id), request));
    }


    public void delete(Long id){
        stopRepository.deleteById(id);
    }

    private Stop stopRequestToStop (Stop stop, StopRequest request){
        if(stop == null){
            stop = new Stop();
        }
        stop.setDescription(request.getDescription());
        stop.setWaitTime(request.getWaitTime());
        stop.setAddress(addressService.findOne(request.getAddressId()));
        return stop;
    }


}