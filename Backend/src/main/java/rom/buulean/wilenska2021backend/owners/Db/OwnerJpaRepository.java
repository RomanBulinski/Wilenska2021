package rom.buulean.wilenska2021backend.owners.Db;

import org.springframework.data.jpa.repository.JpaRepository;
import rom.buulean.wilenska2021backend.owners.Domain.Owner;

import java.util.Optional;

public interface OwnerJpaRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByNameIgnoreCase(String name);

}
