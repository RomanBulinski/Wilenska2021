package rom.buulean.wilenska2021backend.dbInitializer.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rom.buulean.wilenska2021backend.dbInitializer.Aplication.port.DBinitializerUseCase;


@Slf4j
@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final DBinitializerUseCase dBinitializerUseCase;

    @PostMapping("/initialization")
    @Transactional
    public void initialize() {
        dBinitializerUseCase.initialize();
    }
}
