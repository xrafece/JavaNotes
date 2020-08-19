package com.xrafece;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.security.Key;
import java.sql.SQLException;
import java.util.Date;

@SpringBootTest
class JjwtApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String xra = Jwts.builder()
		        .setSubject("Xra")
		        .setExpiration(new Date(System.currentTimeMillis()+3000))
		        .setIssuedAt(new Date())
		        .claim("sss", false)
                .signWith(key)
		        .compact();
        System.out.println(xra);
        try {

        	// Thread.sleep(3100);
            Jws<Claims> jws = Jwts.parserBuilder().setSigningKey(key).requireSubject("Xra").build().parseClaimsJws(xra);
            //OK, we can trust this JWT
            System.out.println(jws);

        } catch (JwtException e) {
        	e.printStackTrace();
            //don't trust the JWT!
        }
    }

    @Test
    void dataSourceTest() throws SQLException {
        System.out.println(dataSource);
    }
}
