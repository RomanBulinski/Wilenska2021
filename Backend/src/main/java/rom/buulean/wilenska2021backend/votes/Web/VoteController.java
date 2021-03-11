package rom.buulean.wilenska2021backend.votes.Web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import rom.buulean.wilenska2021backend.votes.Aplication.port.VoteUseCase;
import rom.buulean.wilenska2021backend.votes.Domain.Vote;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/votes")
public class VoteController {

    private VoteUseCase voteUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Vote> findAll() {
        return voteUseCase.findAll();
    }

}
