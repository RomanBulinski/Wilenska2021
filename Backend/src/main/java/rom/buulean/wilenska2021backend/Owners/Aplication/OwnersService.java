package rom.buulean.wilenska2021backend.Owners.Aplication;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rom.buulean.wilenska2021backend.Owners.Aplication.port.OwnersUseCase;
import rom.buulean.wilenska2021backend.Owners.Db.OwnerJpaRepository;
import rom.buulean.wilenska2021backend.Owners.Domain.Owner;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnersService implements OwnersUseCase {

    private final OwnerJpaRepository ownerJpaRepository;

    @Override
    public List<Owner> findAll() {
        return ownerJpaRepository.findAll();
    }
}
