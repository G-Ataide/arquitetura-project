package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.User;
import academy.devdojo.springboot2.request.TicketRequest;
import academy.devdojo.springboot2.response.TokenResponseBody;
import academy.devdojo.springboot2.service.CriptoService;
import academy.devdojo.springboot2.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airtravel")
@Log4j2
@RequiredArgsConstructor
public class TicketController {

    @Autowired
    private final TicketService ticketService;

    @PostMapping(path = "/buy")
    public ResponseEntity<TokenResponseBody> create(@RequestBody TicketRequest ticketRequest){
        String msg = ticketService.create(ticketRequest);
        if (msg != null){
            return ResponseEntity.ok(TokenResponseBody.builder().token(msg).build());
        }
        return ResponseEntity.notFound().build();
    }

//    public ResponseEntity<TokenResponseBody> validSession(@PathVariable String token){
//        String msg = userService.validSession(token);
//        if (msg != null){
//            return ResponseEntity.ok(TokenResponseBody.builder().token(msg).build());
//        }
//        return ResponseEntity.notFound().build();
//    }

}
