package rom.buulean.wilenska2021backend.RealEstats.Domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
public class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String realEstateNumber;
    private RealEstateType realEstateType;
    private Integer level;
    private Integer participation;

    public RealEstate(String realEstateNumber, RealEstateType realEstateType, Integer level, Integer participation) {
        this.realEstateNumber = realEstateNumber;
        this.realEstateType = realEstateType;
        this.level = level;
        this.participation = participation;
    }

    public enum RealEstateType{
        FLAT, GARAGE
    }

}
