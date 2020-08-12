package com.xrafece.temp;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.xrafece.util.JWTUtils;
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
        Verification require = JWT.require(JWTUtils.algorithm);
        JWTVerifier build = require.withIssuer("Xrafece").build();
        HashMap<String, String> map = new HashMap<>();
        map.put("user", "sXrec");
        map.put("name", "John Doe");
        String token = JWTUtils.getToken(map);
        DecodedJWT verify = build.verify(token);
        System.out.println(verify.getClaim("user").asString());
        System.out.println(verify.getSignature());
        System.out.println(verify.getExpiresAt());
    }
}
