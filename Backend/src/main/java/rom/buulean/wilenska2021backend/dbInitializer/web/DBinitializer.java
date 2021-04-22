package rom.buulean.wilenska2021backend.dbInitializer.web;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rom.buulean.wilenska2021backend.dbInitializer.Aplication.port.DBinitializerUseCase;
import rom.buulean.wilenska2021backend.owners.Db.OwnerJpaRepository;
import rom.buulean.wilenska2021backend.owners.Domain.Owner;
import rom.buulean.wilenska2021backend.realEstats.Db.RealEstateJpaRepository;
import rom.buulean.wilenska2021backend.realEstats.Domain.RealEstate;
import rom.buulean.wilenska2021backend.realEstats.Domain.RealEstate.RealEstateType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class DBinitializer implements DBinitializerUseCase {

    private final RealEstateJpaRepository realEstateJpaRepository;
    private final OwnerJpaRepository ownerJpaRepository;

    @Override
    @Transactional
    public void initialize() {
        initDate();
    }

    private void initDate() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("wilenska04.csv").getInputStream()))) {
            CsvToBean<CsvWilenska> build = new CsvToBeanBuilder<CsvWilenska>(reader)
                    .withType(CsvWilenska.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            build.stream().forEach(this::initRealEstateAndOwners);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to parse CSV file", e);
        }
    }

    private void initRealEstateAndOwners(CsvWilenska csvWilenska) {

        RealEstate realEstate = new RealEstate(
                csvWilenska.realEstate.split(" ")[1],
                Integer.parseInt(csvWilenska.participation),
                setRealEstateType(csvWilenska)
        );
        realEstateJpaRepository.save(realEstate);

        Owner owner = getOrCreateOwner(csvWilenska.ownerName);
        List<RealEstate> existingRealEstates = owner.getRealEstates();

        if (!Objects.isNull(existingRealEstates)) {
            existingRealEstates.add(realEstate);
            owner.setRealEstates(existingRealEstates);
        } else {
            List<RealEstate> newRealEstates = new ArrayList<>();
            newRealEstates.add(realEstate);
            owner.setRealEstates(newRealEstates);
        }
    }

    private RealEstateType setRealEstateType(CsvWilenska csvWilenska) {
        String item = csvWilenska.realEstate.split(" ")[1].split("/")[1];
        if (item.startsWith("G") || item.startsWith("M")) {
            return RealEstateType.GARAGE;
        } else {
            return RealEstateType.FLAT;
        }
    }

    private Owner getOrCreateOwner(String name) {
        return ownerJpaRepository.findByNameIgnoreCase(name).orElseGet(
                () -> ownerJpaRepository.save(new Owner(name))
        );
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CsvWilenska {
        @CsvBindByName
        private String ownerName;
        @CsvBindByName
        private String realEstate;
        @CsvBindByName
        private String participation;
    }

}
