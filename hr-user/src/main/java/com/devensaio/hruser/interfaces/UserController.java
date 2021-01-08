package com.devensaio.hruser.interfaces;

import com.devensaio.hruser.entities.User;
import com.devensaio.hruser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserRepository repository;

    @GetMapping(value="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = repository.findById(id).get();
        return ResponseEntity.ok(user);
    }

    @GetMapping(value="/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User user = repository.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
