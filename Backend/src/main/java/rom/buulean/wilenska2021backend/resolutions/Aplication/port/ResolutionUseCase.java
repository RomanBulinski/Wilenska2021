package rom.buulean.wilenska2021backend.resolutions.Aplication.port;

import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;
import java.util.List;

public interface ResolutionUseCase {

    List<Resolution> findAll();

}
