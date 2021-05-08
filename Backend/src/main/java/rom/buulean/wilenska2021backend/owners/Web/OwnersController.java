package rom.buulean.wilenska2021backend.owners.Web;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rom.buulean.wilenska2021backend.owners.Aplication.port.OwnersUseCase;
import rom.buulean.wilenska2021backend.owners.Aplication.port.OwnersUseCase.CreateOwnerCommand;
import rom.buulean.wilenska2021backend.owners.Domain.Owner;
import rom.buulean.wilenska2021backend.realEstats.Domain.RealEstate;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin
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

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if (id.equals(42L)) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "I am a teapot");
        }
        return ownersUseCase
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{name}/name")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return ownersUseCase
                .findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Owner> addOwner(@Valid @RequestBody RestOwnerCommand restOwnerCommand) {
        Owner owner = ownersUseCase.addOwner( restOwnerCommand.toCreateOwnerCommand() );
        return ResponseEntity.created(createdOwnerUri(owner)).build();
    }

    private URI createdOwnerUri(Owner owner) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + owner.getId().toString()).build().toUri();
        return uri;
    }

    @Data
    private static class RestOwnerCommand {
        String name;
        String phone;
        String email;
        List<RealEstate> realEstates;

        CreateOwnerCommand toCreateOwnerCommand(){
            return new CreateOwnerCommand(name,phone,email,realEstates );
        }
    }
}
