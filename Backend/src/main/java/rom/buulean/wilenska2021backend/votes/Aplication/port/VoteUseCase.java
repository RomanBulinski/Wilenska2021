package rom.buulean.wilenska2021backend.votes.Aplication.port;

import lombok.Value;
import rom.buulean.wilenska2021backend.realEstats.Domain.RealEstate;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;
import rom.buulean.wilenska2021backend.votes.Domain.Vote;
import rom.buulean.wilenska2021backend.votes.Domain.Vote.VoteType;
import java.util.List;

public interface VoteUseCase {

    List<Vote> findAll();

    Vote addVote( CreateVoteCommand voteCommand );

    @Value
    class CreateVoteCommand {
         RealEstate realEstate;
         Resolution resolution;
         VoteType voteType;
    }
}
