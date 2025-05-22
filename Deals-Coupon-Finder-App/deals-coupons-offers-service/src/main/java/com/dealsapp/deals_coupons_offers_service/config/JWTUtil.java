package com.dealsapp.deals_coupons_offers_service.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

    private final String SECRET = "dealsappsecret";

    public String extractUsername(String token) {
        return extractClaim(token).getSubject();
    }

    public String extractRole(String token) {
        return extractClaim(token).get("role", String.class);
    }

    public boolean validateToken(String token) {
        try {
            extractClaim(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims extractClaim(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }
}

