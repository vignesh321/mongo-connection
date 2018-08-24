package com.techprimers.security.jwtsecurity.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.techprimers.security.jwtsecurity.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	/*10 days Expire Time
    private long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; 
    
    */
    private long EXPIRATIONTIME = 1000*60*2;  // 2 minutes



    public String generate(JwtUser jwtUser) {


        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName()).setExpiration(new Date( System.currentTimeMillis() + EXPIRATIONTIME));
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)
               // .setExpiration(  new Date( System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}
