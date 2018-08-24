package com.techprimers.security.jwtsecurity.security;

import com.techprimers.security.jwtsecurity.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

	private long EXPIRATIONTIME  = 1000*60*2; //2 minutes
    private String secret = "youtube";

    public JwtUser validate(String token) {

    	//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aWduIiwidXNlcklkIjoiMTIzNDQiLCJyb2xlIjoiYWRtaW4iLCJleHAiOjE1MzQ2MTA4ODV9.n1cTvXvKz_BifcO65lvRRmsUVsrdVufveTIG-B0Dm1BsBZLn6Q4fgN8kMB69FkG5Enc7aOCulMC1Wk5NuVIc9Q
    	//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aWduIiwidXNlcklkIjoiMTIzNDQiLCJyb2xlIjoiYWRtaW4iLCJleHAiOjE1MzQ2MTIxMTl9.Mcd7b5UdGdRDONkUPXHK6dm9PCxZfCCZvm33P7t8-e9TJ-3uxUP79yLreJWmEwlccK1KOgBQq0LkoZ_3z8oUEQ
        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
            		.setSigningKey(secret)
            		//.requireExpiration( new Date( System.currentTimeMillis() + EXPIRATIONTIME) )
                    .parseClaimsJws(token)
                    
                    .getBody();

            jwtUser = new JwtUser();

            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
