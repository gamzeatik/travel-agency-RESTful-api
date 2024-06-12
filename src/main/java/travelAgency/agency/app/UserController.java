package travelAgency.agency.app;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travelAgency.agency.application.LogoutService;
import travelAgency.agency.application.UserService;
import travelAgency.agency.domain.TokenResponse;

@CrossOrigin(origins = "https://www.comfortabletransfer.com")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final LogoutService logoutService;

    public UserController(UserService userService, LogoutService logoutService) {
        this.userService = userService;
        this.logoutService = logoutService;
    }

    public record UserDto(String username, String email, String password) {

    }

    @PostMapping("/register")
    public TokenResponse registerUser(@RequestBody UserDto user) {
        return userService.register(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        logoutService.logout(request, response, null);
        return ResponseEntity.status(HttpStatus.OK).body("Logout successful");
    }

    @GetMapping("/check/token")
    public boolean checkToken(HttpServletRequest request) {
        return userService.checkToken(request);
    }

    public record LoginDto(String username, String password) {
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginDto user) {
        return userService.authenticate(user);
    }
}
