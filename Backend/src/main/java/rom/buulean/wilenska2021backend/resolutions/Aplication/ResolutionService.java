package rom.buulean.wilenska2021backend.resolutions.Aplication;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rom.buulean.wilenska2021backend.resolutions.Aplication.port.ResolutionUseCase;
import rom.buulean.wilenska2021backend.resolutions.Db.ResolutionJpaRepository;
import rom.buulean.wilenska2021backend.resolutions.Domain.Resolution;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ResolutionService implements ResolutionUseCase {

    private ResolutionJpaRepository resolutionJpaRepository;

    @Override
    public List<Resolution> findAll() {
        return resolutionJpaRepository.findAll();
    }

    public Optional<Resolution> findByTitle(String title) {
        return resolutionJpaRepository.findByTitle(title);
    }

    @Override
    public void addResolution(CreateResolutionCommand createResolutionCommand) {
        Resolution  resolution = new Resolution(
                createResolutionCommand.getTitle(),
                createResolutionCommand.getContent(),
                createResolutionCommand.getYear());
        resolutionJpaRepository.save(resolution);
    }
}
