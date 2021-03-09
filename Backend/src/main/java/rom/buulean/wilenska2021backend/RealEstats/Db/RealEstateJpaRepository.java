package rom.buulean.wilenska2021backend.RealEstats.Db;

import org.springframework.data.jpa.repository.JpaRepository;
import rom.buulean.wilenska2021backend.RealEstats.Domain.RealEstate;

public interface RealEstateJpaRepository extends JpaRepository<RealEstate, Long> {
}
