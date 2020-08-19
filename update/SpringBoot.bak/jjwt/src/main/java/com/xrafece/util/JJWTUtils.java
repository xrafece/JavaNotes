package com.xrafece.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author Xrafece
 */
public class JJWTUtils {
    public static final String SECRET = "ONE*911@9621&9376";
    public static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String getToken(Map<String, Object> claims) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setExpiration(getExpiration())
                .setIssuer("Xrafece")
                .setIssuedAt(new Date());
        claims.forEach(jwtBuilder::claim);

        return jwtBuilder.signWith(SECRET_KEY).compact();
    }

    public static String getToken(String sub, Map<String, Object> claims) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setIssuer("Xrafece")
                .setSubject(sub)
                .setExpiration(getExpiration())
                .setIssuedAt(new Date())
                .setId(UUID.randomUUID().toString());
        claims.forEach(jwtBuilder::claim);
        return jwtBuilder
                .signWith(SECRET_KEY)
                .compact();
    }
    public static String getTokenWithAllChaims(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).signWith(SECRET_KEY).compact();
    }

    /**
     * 过期时间3小时
     *
     * @return Expiration 过期时间
     */
    private static Date getExpiration() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR, 3);
        return instance.getTime();
    }

    /**
     * 过期时间30秒
     *
     * @return Expiration 过期时间
     */
    private static Date getShortExpiration() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 30);
        return instance.getTime();
    }

    /**
     * 过期时间一天
     *
     * @return Expiration 过期时间
     */
    private static Date getLongExpiration() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 1); //一天过期
        return instance.getTime();
    }

    public static void verifyToken(String token) {
        // try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
        // } catch (ExpiredJwtException e) {
        //     e.printStackTrace();
        // } catch (UnsupportedJwtException e) {
        //     e.printStackTrace();
        // } catch (MalformedJwtException e) {
        //     e.printStackTrace();
        // } catch (SignatureException e) {
        //     e.printStackTrace();
        // } catch (IllegalArgumentException e) {
        //     e.printStackTrace();
        // }
    }

    public static Jws<Claims> getTokenInfo(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
    }
}
