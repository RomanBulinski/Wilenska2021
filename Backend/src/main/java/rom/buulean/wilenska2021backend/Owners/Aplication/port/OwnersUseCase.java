package rom.buulean.wilenska2021backend.Owners.Aplication.port;


import rom.buulean.wilenska2021backend.Owners.Domain.Owner;

import java.util.List;

public interface OwnersUseCase {
    List<Owner> findAll();
}
