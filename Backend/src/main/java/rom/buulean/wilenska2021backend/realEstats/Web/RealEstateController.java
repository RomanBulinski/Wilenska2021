package rom.buulean.wilenska2021backend.realEstats.Web;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rom.buulean.wilenska2021backend.realEstats.Aplication.port.RealEstateUseCase;
import rom.buulean.wilenska2021backend.realEstats.Aplication.port.RealEstateUseCase.CreateRealEstateCommand;
import rom.buulean.wilenska2021backend.realEstats.Domain.RealEstate;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/realEstates")
public class RealEstateController {

    private final RealEstateUseCase realEstateUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if (id.equals(42L)) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "I am a teapot");
        }
        return realEstateUseCase
                .findRealEstateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_ADMIN1"})
    public List<RealEstate> findAll() {
        return realEstateUseCase.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addRealEstate(@Valid @RequestBody RestRealEstateCommand restRealEstateCommand) {
        RealEstate realEstate = realEstateUseCase.addRealEstate( restRealEstateCommand.toCreateRealEstateCommand(restRealEstateCommand) );
        return ResponseEntity.created( createdRealEstateUri(realEstate) ).build();
    }

    private URI createdRealEstateUri(RealEstate realEstate) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + realEstate.getId().toString()).build().toUri();
        return uri;
    }

    @Data
    private static class RestRealEstateCommand{
         String realEstateNumber;
         RealEstate.RealEstateType realEstateType;
         Integer level;
         Integer participation;

        CreateRealEstateCommand toCreateRealEstateCommand( RestRealEstateCommand command ){
            return new CreateRealEstateCommand(
                    command.getRealEstateNumber(),
                    command.getRealEstateType(),
                    command.getLevel(),
                    command.getParticipation()
                    );
        }

    }

}
