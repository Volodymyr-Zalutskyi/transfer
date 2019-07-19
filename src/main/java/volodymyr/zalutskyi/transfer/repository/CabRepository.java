package volodymyr.zalutskyi.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volodymyr.zalutskyi.transfer.entity.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Long> {
}
