package rom.buulean.wilenska2021backend.resolutions.Aplication.port;

import lombok.Value;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;
import java.util.List;

public interface ResolutionUseCase {

    List<Resolution> findAll();

    void addResolution( CreateResolutionCommand createResolutionCommand);


    @Value
    class CreateResolutionCommand{
        String title;
        String content;
    }

}
