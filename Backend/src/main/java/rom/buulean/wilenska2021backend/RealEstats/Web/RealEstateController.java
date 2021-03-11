package rom.buulean.wilenska2021backend.RealEstats.Web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rom.buulean.wilenska2021backend.RealEstats.Aplication.port.RealEstateUseCase;
import rom.buulean.wilenska2021backend.RealEstats.Domain.RealEstate;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/realEstates")
public class RealEstateController {

    private final RealEstateUseCase realEstateUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RealEstate> findAll() {
        return realEstateUseCase.findAll();
    }

}
