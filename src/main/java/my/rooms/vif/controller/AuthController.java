package my.rooms.vif.controller;

import my.rooms.vif.data.AuthData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping
public class AuthController {

    @Value("${spring.security.user.name}")
    private String username;
    @Value("${spring.security.user.password}")
    private String encodedPassword;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/auth")
    public ResponseEntity<Boolean> authenticate(@RequestBody AuthData user) {
        boolean matches = username.equals(user.getName()) && encodedPassword.equals(user.getPassword());
        return ResponseEntity.ok(matches);
    }
}
