package rom.buulean.wilenska2021backend.RealEstats.Aplication;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rom.buulean.wilenska2021backend.RealEstats.Aplication.port.RealEstateUseCase;
import rom.buulean.wilenska2021backend.RealEstats.Db.RealEstateJpaRepository;
import rom.buulean.wilenska2021backend.RealEstats.Domain.RealEstate;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RealEstateService implements RealEstateUseCase {

    private final RealEstateJpaRepository realEstateJpaRepository;

    @Override
    public List<RealEstate> findAll() {
        return realEstateJpaRepository.findAll();
    }

    @Override
    public RealEstate addRealEstate(CreateRealEstateCommand createRealEstateCommand) {

        RealEstate realEstate = new RealEstate(
                createRealEstateCommand.getRealEstateNumber(),
                createRealEstateCommand.getRealEstateType(),
                createRealEstateCommand.getLevel(),
                createRealEstateCommand.getParticipation()
                );
        return realEstateJpaRepository.save(realEstate);
    }

    @Override
    public Optional<RealEstate> findRealEstateById(Long id) {
        return  realEstateJpaRepository.findById(id);
    }


}