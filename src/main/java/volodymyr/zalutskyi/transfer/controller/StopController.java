package volodymyr.zalutskyi.transfer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volodymyr.zalutskyi.transfer.dto.request.StopRequest;
import volodymyr.zalutskyi.transfer.dto.response.StopResponse;
import volodymyr.zalutskyi.transfer.service.StopServiсe;

import javax.validation.Valid;
import java.util.List;

import static volodymyr.zalutskyi.transfer.tool.Constants.STOP_URL;
import static volodymyr.zalutskyi.transfer.tool.Constants.STOP_URL;

@CrossOrigin
@RestController
@RequestMapping(STOP_URL)
public class StopController {

    @Autowired
    private StopServiсe stopServiсe;

    @PostMapping
    public void create(@Valid @RequestBody StopRequest request){
        stopServiсe.create(request);
    }

    @GetMapping
    public List<StopResponse> findAll(){
        return stopServiсe.findAll();
    }

    @PutMapping
    public void update(long id, @Valid @RequestBody StopRequest request){
        stopServiсe.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id){
        stopServiсe.delete(id);
    }
}
