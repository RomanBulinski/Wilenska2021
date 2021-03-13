package rom.buulean.wilenska2021backend.votes.Domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import rom.buulean.wilenska2021backend.RealEstats.Domain.RealEstate;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private RealEstate realEstate;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Resolution resolution;

    private VoteType voteType;

    public Vote(RealEstate realEstate, Resolution resolution, VoteType voteType) {
        this.realEstate = realEstate;
        this.resolution = resolution;
        this.voteType = voteType;
    }



    public enum VoteType{
        YES, NO, ZERO
    }



}
