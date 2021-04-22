package rom.buulean.wilenska2021backend.realEstats.Aplication;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import rom.buulean.wilenska2021backend.realEstats.Aplication.port.RealEstateUseCase;
import rom.buulean.wilenska2021backend.realEstats.Db.RealEstateJpaRepository;
import rom.buulean.wilenska2021backend.realEstats.Domain.RealEstate;
import rom.buulean.wilenska2021backend.realEstats.Web.RealEstateController;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.ANY)
@RunWith(SpringRunner.class)
class RealEstateServiceTest {

    @Autowired
    RealEstateController realEstateController;
    @Autowired
    RealEstateJpaRepository realEstateJpaRepository;

    @Test
    public void shouldReturnAllRealEstates() {

        // give
        realEstateJpaRepository.save( new RealEstate("m4"));
        realEstateJpaRepository.save( new RealEstate("m5"));
        // when
        List<RealEstate> allEstates = realEstateController.findAll();
        System.out.println(allEstates);

        // then
        assertEquals(2, allEstates.size());

    }

}
