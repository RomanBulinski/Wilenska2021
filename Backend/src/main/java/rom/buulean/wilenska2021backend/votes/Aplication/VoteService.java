package rom.buulean.wilenska2021backend.votes.Aplication;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rom.buulean.wilenska2021backend.Owners.Db.OwnerJpaRepository;
import rom.buulean.wilenska2021backend.votes.Aplication.port.VoteUseCase;
import rom.buulean.wilenska2021backend.votes.Db.VoteJpaRepository;
import rom.buulean.wilenska2021backend.votes.Domain.Vote;

import java.util.List;

@Service
@AllArgsConstructor
public class VoteService implements VoteUseCase {

    private final VoteJpaRepository voteJpaRepository;

    @Override
    public List<Vote> findAll() {
        return voteJpaRepository.findAll();
    }

    @Override
    public Vote addVote(VoteCommand voteCommand) {
        Vote vote = new Vote(voteCommand.getRealEstate(), voteCommand.getResolution(), voteCommand.getVoteType());
        System.out.println(vote);
        return voteJpaRepository.save(vote);
    }


}
