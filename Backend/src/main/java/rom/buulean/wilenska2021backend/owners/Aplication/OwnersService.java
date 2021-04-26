package rom.buulean.wilenska2021backend.owners.Aplication;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rom.buulean.wilenska2021backend.owners.Aplication.port.OwnersUseCase;
import rom.buulean.wilenska2021backend.owners.Db.OwnerJpaRepository;
import rom.buulean.wilenska2021backend.owners.Domain.Owner;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OwnersService implements OwnersUseCase {

    private final OwnerJpaRepository ownerJpaRepository;

    @Override
    public List<Owner> findAll() {
        return ownerJpaRepository.findAll();
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return ownerJpaRepository.findById(id);
    }

    @Override
    public Optional<Owner> findByName(String name) {
        return ownerJpaRepository.findByName(name);
    }

    @Override
    public Owner addOwner(CreateOwnerCommand createOwnerCommand) {
        Owner owner = new Owner(
                createOwnerCommand.getName(),
                createOwnerCommand.getPhone(),
                createOwnerCommand.getEmail(),
                createOwnerCommand.getRealEstates()
                );
        return ownerJpaRepository.save(owner);
    }
}
