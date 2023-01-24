package com.example.lottopower.config;

import com.example.lottopower.models.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class TokenGenerator {
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    private static final String SECRET = "MySecret";
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";

    public static String generateToken(String email, String[] roles) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        String jwt = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .claim("roles", roles)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        return TOKEN_PREFIX + " " + jwt;
    }
}

