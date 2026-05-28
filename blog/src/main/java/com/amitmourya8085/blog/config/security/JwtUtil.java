package com.amitmourya8085.blog.config.security;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import static java.security.KeyRep.Type.SECRET;

@Component
public class JwtUtil {
    private String secret ="mysecretkeymysecretkeymysecretkey12";
    private Key getSignKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);//due to problem not used getbyte()
    }
    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000) )
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject()
                ;
    }
}
