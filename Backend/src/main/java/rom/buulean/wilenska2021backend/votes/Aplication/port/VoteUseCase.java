package rom.buulean.wilenska2021backend.votes.Aplication.port;

import rom.buulean.wilenska2021backend.votes.Domain.Vote;
import java.util.List;

public interface VoteUseCase {
    List<Vote> findAll();
}
