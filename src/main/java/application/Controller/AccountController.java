package application.Controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController()
@RequestMapping("/account")
public class AccountController {
    public AccountController() {
    }

    @GetMapping(path = "/test")
    public String getUsers() {
        return "test";
    }
}
