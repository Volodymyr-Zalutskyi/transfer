package volodymyr.zalutskyi.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volodymyr.zalutskyi.transfer.dto.request.CabRequest;
import volodymyr.zalutskyi.transfer.dto.response.CabResponse;
import volodymyr.zalutskyi.transfer.service.CabService;

import javax.validation.Valid;
import java.util.List;

import static volodymyr.zalutskyi.transfer.tool.Constants.PRICE_URL;

@CrossOrigin
@RestController
@RequestMapping(PRICE_URL)
public class PriceController {

    @Autowired
    private CabService cabService;

    @PostMapping
    public void create(@Valid @RequestBody CabRequest request) {
        cabService.create(request);
    }

    @GetMapping
    public List<CabResponse> findAll(){
        return cabService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody CabRequest request){
        cabService.update(id, request);
   }

    @DeleteMapping
    public void delete(Long id){
        cabService.delete(id);
   }
}
