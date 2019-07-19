package volodymyr.zalutskyi.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volodymyr.zalutskyi.transfer.entity.Client;

@Repository
public interface ClientRepositiry extends JpaRepository<Client, Long> {
}
