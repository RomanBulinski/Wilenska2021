package rom.buulean.wilenska2021backend.votes.Web;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rom.buulean.wilenska2021backend.realEstats.Domain.RealEstate;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;
import rom.buulean.wilenska2021backend.votes.Aplication.port.VoteUseCase;
import rom.buulean.wilenska2021backend.votes.Aplication.port.VoteUseCase.CreateVoteCommand;
import rom.buulean.wilenska2021backend.votes.Domain.Vote;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/votes")
public class VoteController {

    private VoteUseCase voteUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Vote> findAll() {
        return voteUseCase.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addVote(@Valid @RequestBody RestVoteCommand restVoteCommand) {
        Vote vote = voteUseCase.addVote(restVoteCommand.toCreateVoteCommand());
        return ResponseEntity.created(createdVoteUri(vote)).build();
    }

    private URI createdVoteUri(Vote vote) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + vote.getId().toString()).build().toUri();
        return uri;
    }

    @Data
    private static class RestVoteCommand{
         RealEstate realEstate;
         Resolution resolution;
         Vote.VoteType voteType;

         CreateVoteCommand toCreateVoteCommand(){
             return  new CreateVoteCommand(realEstate, resolution, voteType);
         }
    }

}
