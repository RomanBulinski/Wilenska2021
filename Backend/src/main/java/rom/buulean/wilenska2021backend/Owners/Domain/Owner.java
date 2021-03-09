package rom.buulean.wilenska2021backend.Owners.Domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;

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
}
