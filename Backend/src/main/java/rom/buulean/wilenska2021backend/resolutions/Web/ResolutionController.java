package rom.buulean.wilenska2021backend.resolutions.Web;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rom.buulean.wilenska2021backend.resolutions.Aplication.port.ResolutionUseCase;
import rom.buulean.wilenska2021backend.resolutions.Aplication.port.ResolutionUseCase.CreateResolutionCommand;
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


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addResolution(@RequestBody RestResolutionCommand restResolutionCommand) {
        resolutionUseCase.addResolution(restResolutionCommand.toResolutionCommand());
    }


    @Data
    private static class RestResolutionCommand {

        String title;
        String content;
        String year;

        CreateResolutionCommand toResolutionCommand() {
            return new CreateResolutionCommand(title, content, year);
        }

    }


}
