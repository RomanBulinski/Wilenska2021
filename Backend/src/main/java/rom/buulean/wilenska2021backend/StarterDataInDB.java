package rom.buulean.wilenska2021backend;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rom.buulean.wilenska2021backend.Owners.Aplication.port.OwnersUseCase;
import rom.buulean.wilenska2021backend.Owners.Aplication.port.OwnersUseCase.CreateOwnerCommand;
import rom.buulean.wilenska2021backend.RealEstats.Aplication.port.RealEstateUseCase;
import rom.buulean.wilenska2021backend.RealEstats.Domain.RealEstate;
import rom.buulean.wilenska2021backend.resolutions.Aplication.port.ResolutionUseCase;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;
import rom.buulean.wilenska2021backend.votes.Aplication.port.VoteUseCase;
import rom.buulean.wilenska2021backend.votes.Aplication.port.VoteUseCase.VoteCommand;
import rom.buulean.wilenska2021backend.votes.Domain.Vote;

import java.util.ArrayList;
import java.util.List;

import static rom.buulean.wilenska2021backend.resolutions.Aplication.port.ResolutionUseCase.CreateResolutionCommand;

@Component
@AllArgsConstructor
public class StarterDataInDB implements CommandLineRunner {

    OwnersUseCase ownersUseCase;
    ResolutionUseCase resolutionUseCase;
    RealEstateUseCase realEstateUseCase;
    VoteUseCase voteUseCase;

    @Override
    public void run(String... args) {
        initOwners();
        initResolutions();
        initVotes();
    }

    private void initOwners() {

        List<CreateOwnerCommand> owners = new ArrayList<>();

        List<RealEstate> kowalskiEstates = new ArrayList<>();
        kowalskiEstates.add(new RealEstate("m1", RealEstate.RealEstateType.FLAT, 1, 6000));
        kowalskiEstates.add(new RealEstate("g1", RealEstate.RealEstateType.GARAGE, 1, 1240));
        owners.add(new CreateOwnerCommand("Marian", "Kowalski", "111-111-111-11", "kowalski@mail", kowalskiEstates));

        List<RealEstate> nowakEstates = new ArrayList<>();
        nowakEstates.add(new RealEstate("m2", RealEstate.RealEstateType.FLAT, 1, 6000));
        owners.add(new CreateOwnerCommand("Janusz", "Nowak", "22-111-111-22", "nowak@mail", nowakEstates));

        owners.stream().forEach((owner) -> ownersUseCase.addOwner(owner));
    }

    private void initResolutions() {
        resolutionUseCase.addResolution(new CreateResolutionCommand("uchwala o robakach", "rerwer kwlkrew jlkewrj rrr", "2018/1"));
        resolutionUseCase.addResolution(new CreateResolutionCommand("uchwala o zielni", "aaaaa bbbb", "2018/2"));
    }

    private void initVotes() {

        System.out.println( realEstateUseCase.findAll().get(0) );
        System.out.println( resolutionUseCase.findAll().get(0) );

        voteUseCase.addVote( new VoteCommand(
                realEstateUseCase.findAll().get(0),
                resolutionUseCase.findAll().get(0),
                Vote.VoteType.YES   ));
    }


}
