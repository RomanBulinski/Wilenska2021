package rom.buulean.wilenska2021backend.Owners.Aplication.port;

import lombok.Value;
import rom.buulean.wilenska2021backend.Owners.Domain.Owner;
import java.util.List;

public interface OwnersUseCase {

    List<Owner> findAll();

    Owner addOwner( CreateOwnerCommand  createOwnerCommand);

    @Value
    class CreateOwnerCommand {
        String firstNames;
        String lastNames;
        String phone;
        String email;
    }

}
