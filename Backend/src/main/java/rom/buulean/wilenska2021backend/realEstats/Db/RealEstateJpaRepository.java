package rom.buulean.wilenska2021backend.realEstats.Db;

import org.springframework.data.jpa.repository.JpaRepository;
import rom.buulean.wilenska2021backend.realEstats.Domain.RealEstate;

import java.util.Optional;

public interface RealEstateJpaRepository extends JpaRepository<RealEstate, Long> {

    Optional<RealEstate> findByRealEstateNumber(String realEstateNumber);


}
