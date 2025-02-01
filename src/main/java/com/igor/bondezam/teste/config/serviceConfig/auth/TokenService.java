package com.igor.bondezam.teste.config.serviceConfig.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.igor.bondezam.teste.domain.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token}")
    private String secret;

    public String createToken(Usuario user) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret); //SEGREDO VINDO DAS VARIAVEIS DE AMBIENTE
            return  JWT.create()
                    .withIssuer("MTG") //QUEM CRIOU O TOKEN
                    .withSubject(user.getEmail()) //USUARIO QUE RECEBE O TOKEN
                    .withClaim("id", user.getId())
                    .withExpiresAt(dateExpiration()) //QUANDO SERÁ EXPIRADO
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error to generate token: ", exception);
        }
    }

    public String validToken(String tokenJwt) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).withIssuer("MTG").build().verify(tokenJwt).getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Invalid token: ", e);
        }
    }

    private Instant dateExpiration() {
        return LocalDateTime.now().plusSeconds(45).toInstant(ZoneOffset.of("-03:00"));
    }
}
