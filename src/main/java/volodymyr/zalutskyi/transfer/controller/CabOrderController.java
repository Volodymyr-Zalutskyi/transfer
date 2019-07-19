package volodymyr.zalutskyi.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volodymyr.zalutskyi.transfer.dto.request.CabOrderRequest;
import volodymyr.zalutskyi.transfer.dto.request.PaginationRequest;
import volodymyr.zalutskyi.transfer.dto.response.CabOrderResponse;
import volodymyr.zalutskyi.transfer.dto.response.PageResponse;
import volodymyr.zalutskyi.transfer.service.CabOrderServiсe;

import javax.validation.Valid;
import java.util.List;

import static volodymyr.zalutskyi.transfer.tool.Constants.BOOKING_URL;
import static volodymyr.zalutskyi.transfer.tool.Constants.PAGE_URL;

@RestController
@RequestMapping(BOOKING_URL)
public class CabOrderController {

    @Autowired
    private CabOrderServiсe cabOrderServiсe;

    @PostMapping
    public void create(@Valid @RequestBody CabOrderRequest request){
        cabOrderServiсe.creat(request);
    }

    @GetMapping
    public List<CabOrderResponse> findAll(){
        return cabOrderServiсe.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody CabOrderRequest request){
        cabOrderServiсe.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id){
        cabOrderServiсe.delete(id);
    }

    @PostMapping(PAGE_URL)
    public PageResponse<CabOrderResponse> findPage(@Valid PaginationRequest paginationRequest) {
        return cabOrderServiсe.findPage(paginationRequest);
    }
//    @PostMapping("/available")
//    public boolean isAvailableOnDate(@Valid @RequestBody CabOrderRequest request){
//        return cabOrderServiсe.isAvailableOnDate(request.getCabId(), request.getDatePickup(),request.getTimePickup());
//    }
}
