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
    private String firstNames;
    private String lastNames;

}
