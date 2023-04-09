package ru.netology.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.exepion.InvalidCredentials;
import ru.netology.exepion.UnauthorizedUser;
import ru.netology.model.Authorities;
import ru.netology.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationControlle {
    AuthorizationService service;

    public AuthorizationControlle(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handlerInvalidCredentials (InvalidCredentials e){
        System.out.println("Exeption: "+ e.getMessage());
        return new ResponseEntity<>("Exeption: "+ e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handlerUnauthorizedUser (UnauthorizedUser e){
        System.out.println("Exeption: "+ e.getMessage());
        return new ResponseEntity<>("Exeption: "+ e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
