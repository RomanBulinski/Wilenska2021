package rom.buulean.wilenska2021backend;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rom.buulean.wilenska2021backend.Owners.Aplication.port.OwnersUseCase;
import rom.buulean.wilenska2021backend.Owners.Aplication.port.OwnersUseCase.CreateOwnerCommand;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class StarterDataInDB implements CommandLineRunner {

    OwnersUseCase ownersUseCase;

    @Override
    public void run(String... args) {
//        initDate();
//        placeOrder();

        List<CreateOwnerCommand> owners = new ArrayList<>();
        owners.add(new CreateOwnerCommand( "Marian", "Kowalski", "333", "e@mail"));
        owners.add(new CreateOwnerCommand( "Janusz", "Nowak", "333", "e@mail"));

        owners.stream().forEach( (owner) -> ownersUseCase.addOwner(owner) );


    }

}
