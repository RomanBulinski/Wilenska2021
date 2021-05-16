package rom.buulean.wilenska2021backend.login.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rom.buulean.wilenska2021backend.login.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin
public class UserLoggerController {

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        return user.checkIfUserAndPasswordCorrespond(userName, password);
    }

    @RequestMapping("/userLogger")
    public Principal userLogger(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
    }
}
