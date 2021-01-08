package com.devensaio.hroauth.interfaces;

import com.devensaio.hroauth.entities.User;
import com.devensaio.hroauth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/users")
public class UserController  {

    private final UserService service;

    @GetMapping(value="/search")
    public ResponseEntity<User> findByEmail(@Valid @RequestParam String email){
        User user = null;
        try {
            user = service.findByEmail(email);
            return ResponseEntity.ok(user);
        } catch (IllegalAccessException e) {
            return new ResponseEntity<User>(HttpStatus.MULTI_STATUS);
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
