package rom.buulean.wilenska2021backend.resolutions.Web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import rom.buulean.wilenska2021backend.resolutions.Aplication.port.ResolutionUseCase;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/resolutions")
public class ResolutionController {

    private ResolutionUseCase resolutionUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Resolution> findAll() {
        return resolutionUseCase.findAll();
    }

}
