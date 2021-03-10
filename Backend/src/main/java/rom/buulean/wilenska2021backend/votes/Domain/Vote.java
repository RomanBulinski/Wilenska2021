package rom.buulean.wilenska2021backend.votes.Domain;

import lombok.*;
import rom.buulean.wilenska2021backend.RealEstats.Domain.RealEstate;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private RealEstate realEstate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Resolution resolution;

    private VoteType voteType;

    enum VoteType{
        YES, NO, ZERO
    }

}
