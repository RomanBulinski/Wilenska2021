package rom.buulean.wilenska2021backend.owners.Db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rom.buulean.wilenska2021backend.owners.Domain.Owner;

import java.util.Optional;

public interface OwnerJpaRepository extends JpaRepository<Owner, Long> {

    @Query(" SELECT b FROM Owner b " +
            " WHERE " +
            " lower(b.name) LIKE  lower(concat('%',:name ,'%'))")
    Optional<Owner> findByName(@Param("name") String name);

//    Optional<Owner> findByNameIgnoreCase(String name);

}
