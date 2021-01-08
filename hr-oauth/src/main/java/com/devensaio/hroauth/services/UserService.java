package com.devensaio.hroauth.services;

import com.devensaio.hroauth.client.UserClient;
import com.devensaio.hroauth.entities.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserClient client;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    public User findByEmail(String email) throws IllegalAccessException {
        User user = client.findByEmail(email).getBody();
        if (user == null){
            logger.error("Email: "+email+" not found");
            throw new IllegalAccessException("Email not found");
        }
        logger.info("Email "+email+ " encontrado");
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = client.findByEmail(username).getBody();
        if (user == null){
            logger.error("Email: "+username+" not found");
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("Email "+username+ " encontrado");
        return user;
    }
}
