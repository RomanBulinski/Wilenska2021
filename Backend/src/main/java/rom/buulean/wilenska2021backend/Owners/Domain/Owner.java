package rom.buulean.wilenska2021backend.Owners.Domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import rom.buulean.wilenska2021backend.RealEstats.Domain.RealEstate;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table( name="owners" )
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstNames;
    private String lastNames;
    private String phone;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="owner_id")
    private List<RealEstate> realEstates;

    public Owner(String firstNames, String lastNames, String phone, String email) {
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.phone = phone;
        this.email = email;
    }

    public Owner(String firstNames, String lastNames, String phone, String email, List<RealEstate> realEstates) {
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.phone = phone;
        this.email = email;
        this.realEstates = realEstates;
    }
}
