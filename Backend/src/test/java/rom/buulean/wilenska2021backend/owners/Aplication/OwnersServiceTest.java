package rom.buulean.wilenska2021backend.owners.Aplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import rom.buulean.wilenska2021backend.owners.Aplication.port.OwnersUseCase;
import rom.buulean.wilenska2021backend.owners.Db.OwnerJpaRepository;;
import rom.buulean.wilenska2021backend.owners.Domain.Owner;
import rom.buulean.wilenska2021backend.realEstats.Domain.RealEstate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.ANY)
class OwnersServiceTest {

    @Autowired
    OwnersService ownersService;

    @Autowired
    OwnerJpaRepository ownerJpaRepository;

    @Test
    public void shouldGetAllOwners() {
        // given
        ownerJpaRepository.save( new Owner("Jan Kowalski"));
        ownerJpaRepository.save( new Owner("Stefan Nowak"));
        // when
        List<Owner> allOwners = ownersService.findAll();
        // then
        assertEquals( 2, allOwners.size());
    }

    @Test
    public void shouldAddOwner() {
        // given
        ownerJpaRepository.save( new Owner("Jan Kowalski"));
        List<RealEstate> realEstates = new ArrayList<>();
        realEstates.add(new RealEstate("m4"));
        // when
        ownersService.addOwner( new OwnersUseCase.CreateOwnerCommand("Waldek Nowak","111-111-111-111","x@com.pl", realEstates));
        // then
        List<Owner> allOwners = ownersService.findAll();
        assertEquals( 2, allOwners.size());
    }


}
