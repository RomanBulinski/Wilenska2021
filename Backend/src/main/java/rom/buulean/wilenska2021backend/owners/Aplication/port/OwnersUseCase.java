package rom.buulean.wilenska2021backend.owners.Aplication.port;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import rom.buulean.wilenska2021backend.owners.Domain.Owner;
import rom.buulean.wilenska2021backend.realEstats.Domain.RealEstate;

import java.util.List;
import java.util.Optional;

public interface OwnersUseCase {

    List<Owner> findAll();

    Optional<Owner> findById(Long id);

    Optional<Owner> findByName(String name);

    Owner addOwner( CreateOwnerCommand  createOwnerCommand);

    @Value
    @Builder
    @AllArgsConstructor
    class CreateOwnerCommand {
        String name;
        String phone;
        String email;
        List<RealEstate> realEstates;
    }

}
