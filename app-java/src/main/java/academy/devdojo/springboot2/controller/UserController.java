package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.User;
import academy.devdojo.springboot2.response.TokenResponseBody;
import academy.devdojo.springboot2.service.CriptoService;
import academy.devdojo.springboot2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@Log4j2
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;


    @PostMapping(path = "/create")
    public ResponseEntity<User> create(@RequestBody User user){
        user.setPassword(CriptoService.encrypt(user.getPassword()));

        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<TokenResponseBody> login(@RequestBody User user){
        String token = userService.login(user);
        if (token != null){
            return ResponseEntity.ok(TokenResponseBody.builder().token(token).build());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/logout/{token}")
    public ResponseEntity<TokenResponseBody> login(@PathVariable String token){
        String msg = userService.logout(token);
        if (msg != null){
            return ResponseEntity.ok(TokenResponseBody.builder().token(msg).build());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/valid-session/{token}")
    public ResponseEntity<TokenResponseBody> validSession(@PathVariable String token){
        String msg = userService.validSession(token);
        if (msg != null){
            return ResponseEntity.ok(TokenResponseBody.builder().token(msg).build());
        }
        return ResponseEntity.notFound().build();
    }

}
