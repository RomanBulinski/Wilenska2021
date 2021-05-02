package rom.buulean.wilenska2021backend.resolutions.Db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;

import java.util.Optional;

public interface ResolutionJpaRepository extends JpaRepository<Resolution, Long> {

    @Query(" SELECT b FROM Resolution b " +
            " WHERE " +
            " lower(b.title) LIKE  lower(concat('%',:title ,'%'))")
    Optional<Resolution> findByTitle(@Param("title") String title);


}
