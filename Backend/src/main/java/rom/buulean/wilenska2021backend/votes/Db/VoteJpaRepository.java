package rom.buulean.wilenska2021backend.votes.Db;

import org.springframework.data.jpa.repository.JpaRepository;
import rom.buulean.wilenska2021backend.votes.Domain.Vote;

public interface VoteJpaRepository extends JpaRepository<Vote, Long> {
}
