package com.xrafece.temp;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @author Xrafece
 */
public class JwtTest {
    @Test
    void name() {
        HashMap<String, Object> hashMap = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 20);
        String token = JWT.create().withHeader(hashMap)
                .withClaim("sub", "xrafece")
                .withClaim("name", "John Doe")
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256("SNIXSINIISINNJ"));
        System.out.println(token);
    }

    @Test
    void test() {
        Verification require = JWT.require(Algorithm.HMAC256("SNIXSINIISINNJ"));
        JWTVerifier build = require.build();
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4cmFmZWNlIiwibmFtZSI6IkpvaG4gRG9lIiwiZXhwIjoxNTk3MTQ0Mjk1fQ.2wB5kTzyIaIqNZgjKn0RHBoT9GUUmT6pzX8W5sPPCvU";
        DecodedJWT verify = build.verify(token);
        System.out.println(verify.getClaim("name").asString());
        System.out.println(verify.getSignature());
        System.out.println(verify.getExpiresAt());
    }
}
