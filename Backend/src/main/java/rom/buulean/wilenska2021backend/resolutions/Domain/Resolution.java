package rom.buulean.wilenska2021backend.resolutions.Domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "resolution")
public class Resolution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String symbolNumber;
    private String title;
    private String content;

    public Resolution(String symbolNumber, String title, String content) {
        this.symbolNumber = symbolNumber;
        this.title = title;
        this.content = content;
    }

    public Resolution(String symbolNumber) {
        this.symbolNumber = symbolNumber;
    }

}

