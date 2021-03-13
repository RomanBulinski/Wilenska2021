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
    private String title;
    private String content;
    private String year;

    public Resolution(String title, String content, String year) {
        this.title = title;
        this.content = content;
        this.year = year;
    }

}

