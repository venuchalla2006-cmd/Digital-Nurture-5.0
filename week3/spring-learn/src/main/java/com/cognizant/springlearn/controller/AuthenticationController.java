package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START - authenticate");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String username = getUser(authHeader);
        String token = generateJwt(username);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.info("END - authenticate");
        return response;
    }

    private String getUser(String authHeader) {
        LOGGER.info("START - getUser");
        // Decode Basic auth header
        String encodedCredentials = authHeader.substring(6); // remove "Basic "
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);
        
        // credentials is in format username:password
        String[] values = credentials.split(":", 2);
        String username = values[0];
        
        LOGGER.debug("Decoded Username: {}", username);
        LOGGER.info("END - getUser");
        return username;
    }

    private String generateJwt(String user) {
        LOGGER.info("START - generateJwt for user: {}", user);
        
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        // Set expiry as 20 minutes from now (1200000 ms)
        builder.setExpiration(new Date(System.currentTimeMillis() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");
        
        String token = builder.compact();
        LOGGER.debug("Generated JWT Token: {}", token);
        LOGGER.info("END - generateJwt");
        return token;
    }
}
