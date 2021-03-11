package rom.buulean.wilenska2021backend.resolutions.Aplication;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rom.buulean.wilenska2021backend.resolutions.Aplication.port.ResolutionUseCase;
import rom.buulean.wilenska2021backend.resolutions.Db.ResolutionJpaRepository;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;
import java.util.List;

@Service
@AllArgsConstructor
public class ResolutionService implements ResolutionUseCase {

    private ResolutionJpaRepository resolutionJpaRepository;

    @Override
    public List<Resolution> findAll() {
        return resolutionJpaRepository.findAll();
    }
}
