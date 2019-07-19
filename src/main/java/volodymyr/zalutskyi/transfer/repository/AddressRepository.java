package volodymyr.zalutskyi.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volodymyr.zalutskyi.transfer.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
