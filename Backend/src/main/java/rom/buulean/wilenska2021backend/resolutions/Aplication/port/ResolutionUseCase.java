package rom.buulean.wilenska2021backend.resolutions.Aplication.port;

import lombok.Value;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;
import java.util.List;
import java.util.Optional;

public interface ResolutionUseCase {

    List<Resolution> findAll();

    void addResolution( CreateResolutionCommand createResolutionCommand);

    Optional<Resolution> findByTitle(String title);

    @Value
    class CreateResolutionCommand{
        String symbolNumber;
        String title;
        String content;
    }

}
