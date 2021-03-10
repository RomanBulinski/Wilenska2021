package rom.buulean.wilenska2021backend.resolutions.Domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import rom.buulean.wilenska2021backend.RealEstats.Domain.RealEstate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@Entity
public class Resolution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

}
