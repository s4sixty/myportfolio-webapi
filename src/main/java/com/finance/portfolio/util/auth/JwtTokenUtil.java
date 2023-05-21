package com.finance.portfolio.util.auth;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.finance.portfolio.domain.dao.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtTokenUtil {
    private static final long EXPIRE_DURATION = (long) 100 * 60 * 60 * 1000; // 100 hours

    @Value("${app.jwt.secret}")
    private String secretKey;

    public String generateAccessToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            return JWT.create()
                    .withIssuer("angel-investor")
                    .withSubject(String.format("%s,%s", user.getId(), user.getEmail()))
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            // Invalid Signing configuration / Couldn't convert Claims.
            throw new InternalAuthenticationServiceException("server access token generation failed");
        }
    }

    public DecodedJWT validateAccessToken(String token) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512(secretKey)).withIssuer("angel-investor").build();
            return jwtVerifier.verify(token);
        } catch (JWTVerificationException ex) {
            throw new JWTVerificationException("Access token is not valid", ex);
        } catch (IllegalArgumentException ex) {
            throw new IllegalStateException("Access token is null, empty or only whitespace", ex);
        } catch (Exception ex) {
            throw new JWTVerificationException("Access token is invalid", ex);
        }
    }
}