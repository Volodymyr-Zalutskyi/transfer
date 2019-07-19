package volodymyr.zalutskyi.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volodymyr.zalutskyi.transfer.entity.CabOrder;
import volodymyr.zalutskyi.transfer.entity.CabOrder;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface CabOrderRepository extends JpaRepository<CabOrder, Long> {

    boolean existsAllByCabIdAndDatePickupAndTimePickup(Long cabId, LocalDate date, LocalTime time);
    }
