package rom.buulean.wilenska2021backend.resolutions.Aplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import rom.buulean.wilenska2021backend.resolutions.Db.ResolutionJpaRepository;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class ResolutionServiceTest {

    @Autowired
    ResolutionJpaRepository resolutionJpaRepository;

    @Autowired
    ResolutionService resolutionService;

    @Test
    public void findByTitle() {
        // given
        resolutionJpaRepository.save(new Resolution("O windach", "Windy tekst uchwały", "2020"));
        // when
        Optional<Resolution> resolution = resolutionService.findByTitle("wind");
        // then
        assertTrue(resolution.isPresent());
    }
}
