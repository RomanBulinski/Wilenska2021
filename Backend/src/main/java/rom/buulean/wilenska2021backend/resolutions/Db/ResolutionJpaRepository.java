package rom.buulean.wilenska2021backend.resolutions.Db;

import org.springframework.data.jpa.repository.JpaRepository;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;

public interface ResolutionJpaRepository extends JpaRepository<Resolution, Long> {
}
