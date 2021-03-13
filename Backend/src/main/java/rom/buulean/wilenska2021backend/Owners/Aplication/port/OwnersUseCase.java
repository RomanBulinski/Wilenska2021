package rom.buulean.wilenska2021backend.Owners.Aplication.port;

import lombok.Value;
import rom.buulean.wilenska2021backend.Owners.Domain.Owner;
import rom.buulean.wilenska2021backend.RealEstats.Domain.RealEstate;

import java.util.List;
import java.util.Optional;

public interface OwnersUseCase {

    List<Owner> findAll();

    Optional<Owner> findById(Long id);

    Owner addOwner( CreateOwnerCommand  createOwnerCommand);

    @Value
    class CreateOwnerCommand {
        String firstNames;
        String lastNames;
        String phone;
        String email;
        List<RealEstate> realEstates;
    }

}
