package rom.buulean.wilenska2021backend.resolutions.Domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

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

