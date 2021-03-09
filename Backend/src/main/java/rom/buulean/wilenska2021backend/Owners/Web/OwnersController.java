package rom.buulean.wilenska2021backend.Owners.Web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rom.buulean.wilenska2021backend.Owners.Aplication.port.OwnersUseCase;
import rom.buulean.wilenska2021backend.Owners.Domain.Owner;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/owners")
public class OwnersController {

    private final OwnersUseCase ownersUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Owner> findAll() {
        return ownersUseCase.findAll();
    }

}
