package rom.buulean.wilenska2021backend.Owners.Db;

import org.springframework.data.jpa.repository.JpaRepository;
import rom.buulean.wilenska2021backend.Owners.Domain.Owner;

public interface OwnerJpaRepository extends JpaRepository<Owner, Long> {
}
