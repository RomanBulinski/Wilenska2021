package rom.buulean.wilenska2021backend.RealEstats.Aplication.port;

import lombok.Value;
import rom.buulean.wilenska2021backend.RealEstats.Domain.RealEstate;
import rom.buulean.wilenska2021backend.RealEstats.Domain.RealEstate.RealEstateType;

import java.util.List;
import java.util.Optional;

public interface RealEstateUseCase {

    List<RealEstate> findAll();

    RealEstate addRealEstate(CreateRealEstateCommand createRealEstateCommand);

    Optional<RealEstate> findRealEstateById(Long id);

    @Value
    class CreateRealEstateCommand {
         String realEstateNumber;
         RealEstateType realEstateType;
         Integer level;
         Integer participation;
    }

}
