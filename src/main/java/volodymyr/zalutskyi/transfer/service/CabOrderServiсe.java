package volodymyr.zalutskyi.transfer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import volodymyr.zalutskyi.transfer.dto.request.CabOrderRequest;
import volodymyr.zalutskyi.transfer.dto.request.PaginationRequest;
import volodymyr.zalutskyi.transfer.dto.request.StopRequest;
import volodymyr.zalutskyi.transfer.dto.response.CabOrderResponse;
import volodymyr.zalutskyi.transfer.dto.response.PageResponse;
import volodymyr.zalutskyi.transfer.entity.CabOrder;
import volodymyr.zalutskyi.transfer.entity.Stop;
import volodymyr.zalutskyi.transfer.repository.CabOrderRepository;
import volodymyr.zalutskyi.transfer.repository.StopRepository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CabOrderServiсe {

    @Autowired
    private CabOrderRepository cabOrderRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private CabService cabService;

    public void creat(CabOrderRequest request) {
        CabOrder cabOrder = cabOrderRepository.save(cabOrderRequestToCabOrder(null, request));
        saveStopsForCarOrder(cabOrder, request);
    }

    public List<CabOrderResponse> findAll(){
        return cabOrderRepository.findAll()
                .stream()
                .map(CabOrderResponse::new)
                .collect(Collectors.toList());
    }
    public PageResponse<CabOrderResponse> findPage(PaginationRequest paginationRequest){
        Page<CabOrder> page = cabOrderRepository.findAll(paginationRequest.toPageable());
        return new PageResponse<>(page.getTotalPages(),
                page.getTotalElements(), page.get().map(CabOrderResponse::new).collect(Collectors.toList()));
    }

    public boolean isAvailableOnDate(Long cabId, LocalDate date, LocalTime from) {
       return !cabOrderRepository.existsAllByCabIdAndDatePickupAndTimePickup(cabId, date, from);

    }

    public CabOrder findOne(Long id){
        return cabOrderRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Cab order with id "+ id +" not exist"));
    }

    public void update(Long id, CabOrderRequest request){
        cabOrderRepository.save(cabOrderRequestToCabOrder(findOne(id), request));
    }

    public void delete(Long id){
        cabOrderRepository.delete(findOne(id));
    }

    public CabOrder cabOrderRequestToCabOrder(CabOrder cabOrder, CabOrderRequest request) {
        if (cabOrder == null) {
            cabOrder = new CabOrder();
            cabOrder.setDateOfOrder(LocalDateTime.now());
        }
            cabOrder.setNameOfClient(request.getNameOfClient());
            cabOrder.setPhoneNumber(request.getPhoneNumber());
            cabOrder.setEmailAddress(request.getEmailAddress());
            cabOrder.setDatePickup(request.getDatePickup());
            cabOrder.setTimePickup(request.getTimePickup());
            cabOrder.setDriveTime(request.getDriveTime());

            if(!isAvailableOnDate(request.getCabId(), request.getDatePickup(), request.getTimePickup())) {
               throw new IllegalArgumentException("Cab order with this date and time are exists");
            }
            cabOrder.setTimePickup(request.getTimePickup());
            cabOrder.setCab(cabService.findOne(request.getCabId()));
            cabOrder.setClient(clientService.findOne(request.getClientId()));
//            if (request.getStopRequests() != null) {
//                cabOrder.setStops(request.getStopRequests()
//                        .stream()
//                        .map(stopRequests::findOne)
//                        .collect(Collectors.toList()));
//           }
            cabOrder.setTimeBack(calculateEndTime(cabOrder));

        return cabOrder;
    }

   private void saveStopsForCarOrder(CabOrder cabOrder, CabOrderRequest request){
        List<Stop> stops = request.getStops().stream().map(p -> stopRequestToCabOrder(cabOrder, p)).collect(Collectors.toList());
        stopRepository.saveAll(stops);
   }

    private Stop stopRequestToCabOrder (CabOrder cabOrder, StopRequest request){
      return Stop.builder()
              .addressStop(request.getAddressStop())
              .description(request.getDescription())
              .waitTime(request.getWaitTime())
              .cabOrder(cabOrder)
              .build();
    }

    private LocalDateTime calculateEndTime(CabOrder cabOrder) {
        Integer awaitTimeOnStops = cabOrder.getStops()
                .stream().map(Stop::getWaitTime)
                .reduce(Integer::sum).orElse(0);
        return  LocalDateTime.of(cabOrder.getDatePickup(), cabOrder.getTimePickup())
                    .plusMinutes(cabOrder.getDriveTime() + awaitTimeOnStops);
    }

}
