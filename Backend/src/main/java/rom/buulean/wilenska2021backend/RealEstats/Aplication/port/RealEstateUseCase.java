package rom.buulean.wilenska2021backend.RealEstats.Aplication.port;

import rom.buulean.wilenska2021backend.RealEstats.Domain.RealEstate;
import java.util.List;

public interface RealEstateUseCase {

    List<RealEstate> findAll();

}
