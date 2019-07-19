package volodymyr.zalutskyi.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volodymyr.zalutskyi.transfer.dto.request.CabRequest;
import volodymyr.zalutskyi.transfer.dto.response.CabResponse;
import volodymyr.zalutskyi.transfer.entity.Cab;
import volodymyr.zalutskyi.transfer.repository.CabRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CabService {

    @Autowired
    private CabRepository cabRepository;

    public void create(CabRequest request){
        cabRepository.save(priceRequestToPrice(null, request));
    }

    public List<CabResponse> findAll(){
        return cabRepository.findAll()
                .stream()
                .map(CabResponse::new).collect(Collectors.toList());
    }

    public Cab findOne(Long id){
        return cabRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Cab with id "+id+" not exist"));
    }

    public void update(Long id, CabRequest request){
        cabRepository.save(priceRequestToPrice(findOne(id), request));
    }

    public void delete(Long id){
        cabRepository.delete(findOne(id));
    }

    public Cab priceRequestToPrice(Cab cab, CabRequest request){
        if(cab == null){
            cab = new Cab();
        }
        cab.setTypeOfCab(request.getTypeOfCab());
        cab.setAmountForOneKm(request.getAmountForOneKm());
        return cab;
    }

}
