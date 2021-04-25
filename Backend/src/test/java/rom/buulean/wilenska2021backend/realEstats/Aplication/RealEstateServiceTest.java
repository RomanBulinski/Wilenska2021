package rom.buulean.wilenska2021backend.realEstats.Aplication;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import rom.buulean.wilenska2021backend.realEstats.Aplication.port.RealEstateUseCase;
import rom.buulean.wilenska2021backend.realEstats.Db.RealEstateJpaRepository;
import rom.buulean.wilenska2021backend.realEstats.Domain.RealEstate;
import rom.buulean.wilenska2021backend.realEstats.Web.RealEstateController;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.ANY)
@RunWith(SpringRunner.class)
class RealEstateServiceTest {

    @Autowired
    RealEstateService realEstateService;
    @Autowired
    RealEstateJpaRepository realEstateJpaRepository;

    @Test
    public void getAllRealEstates() {
        // given
        realEstateJpaRepository.save( new RealEstate("m4"));
        realEstateJpaRepository.save( new RealEstate("m5"));
        // when
        List<RealEstate> allEstates = realEstateService.findAll();
        // then
        assertEquals( 2, allEstates.size());
    }

    @Test
    public void getRealEstateById() {
        // given
        realEstateJpaRepository.save( new RealEstate("m4"));
        realEstateJpaRepository.save( new RealEstate("m5"));
        // when
        Optional<RealEstate> realEstate = realEstateService.findRealEstateById(1L);
        // then
        assertEquals(1L, realEstate.get().getId());
    }

}
