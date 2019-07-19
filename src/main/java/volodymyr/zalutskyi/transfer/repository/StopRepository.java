package volodymyr.zalutskyi.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volodymyr.zalutskyi.transfer.entity.Stop;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {
}
