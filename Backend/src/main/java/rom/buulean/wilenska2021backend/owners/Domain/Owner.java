package rom.buulean.wilenska2021backend.owners.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import rom.buulean.wilenska2021backend.realEstats.Domain.RealEstate;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "owners")
@AllArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private List<RealEstate> realEstates;

    public Owner(){}

    public Owner(String name) {
        this.name = name;
    }

    public Owner(String name, String phone, String email, List<RealEstate> realEstates) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.realEstates = realEstates;
    }



}
