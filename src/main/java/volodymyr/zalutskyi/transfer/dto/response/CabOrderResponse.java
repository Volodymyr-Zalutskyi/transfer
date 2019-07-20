package volodymyr.zalutskyi.transfer.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import volodymyr.zalutskyi.transfer.entity.CabOrder;
import volodymyr.zalutskyi.transfer.entity.Stop;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CabOrderResponse {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private LocalDate datePickup;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime timePickup;
    private ClientResponse clientResponses;
    private CabResponse cabResponses;
    private List<StopResponse> stopResponses;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime dateOfOrder;
    private Integer driveTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalDateTime timeBack;


    public CabOrderResponse(CabOrder cabOrder){
        id = cabOrder.getId();
        datePickup = cabOrder.getDatePickup();
        timePickup = cabOrder.getTimePickup();
        clientResponses = new ClientResponse(cabOrder.getClient());
        cabResponses = new CabResponse(cabOrder.getCab());
        stopResponses = cabOrder.getStops().stream().map(StopResponse::new).collect(Collectors.toList());
        dateOfOrder = cabOrder.getDateOfOrder();
        driveTime = cabOrder.getDriveTime();
        timeBack = LocalDateTime.of(cabOrder.getDatePickup(), cabOrder.getTimePickup().plusMinutes(cabOrder.getDriveTime() + cabOrder.getStops()
                .stream().map(Stop::getWaitTime)
                .reduce(Integer::sum).orElse(0)));

    }

}
