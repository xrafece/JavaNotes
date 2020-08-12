package com.xrafece.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @author Xrafece
 */
public class JWTUtils {

    private static final String SCREAT = "5411D2BDE1B91FB8C4927CFE255EDFFA";

    public static Algorithm algorithm = Algorithm.HMAC256(SCREAT);

    public static String getToken(Map<String, String> map) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7); // 默认七天过期

        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v)->{
            builder.withClaim(k, v);
        });
        builder.withExpiresAt(calendar.getTime());
        builder.withIssuedAt(new Date());
        builder.withIssuer("Xrafece");

        String token = builder.sign(algorithm);

        return token;
    }

    public static void verify(String token) {
        JWT.require(algorithm).build().verify(token);
    }

    public static DecodedJWT getTokenInfo(String token) {
        return JWT.require(algorithm).build().verify(token);
    }

}
