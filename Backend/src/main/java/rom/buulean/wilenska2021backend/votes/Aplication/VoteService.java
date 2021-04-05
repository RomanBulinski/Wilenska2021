package rom.buulean.wilenska2021backend.votes.Aplication;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rom.buulean.wilenska2021backend.votes.Aplication.port.VoteUseCase;
import rom.buulean.wilenska2021backend.votes.Db.VoteJpaRepository;
import rom.buulean.wilenska2021backend.votes.Domain.Vote;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class VoteService implements VoteUseCase {

    private final VoteJpaRepository voteJpaRepository;

    @Override
    public List<Vote> findAll() {
        return voteJpaRepository.findAll();
    }

    @Override
    public Vote addVote(CreateVoteCommand voteCommand) {
        Vote vote = new Vote(voteCommand.getRealEstate(), voteCommand.getResolution(), voteCommand.getVoteType());
        log.info(String.valueOf(vote));
        return voteJpaRepository.save(vote);
    }


}
