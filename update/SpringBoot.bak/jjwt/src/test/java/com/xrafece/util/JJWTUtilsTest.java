package com.xrafece.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author Xrafece
 */
class JJWTUtilsTest {

    @Test
    void getToken() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "oneStep");
        String token = JJWTUtils.getToken(map);
        System.out.println(token);
    }

    @Test
    void testGetToken() {
    }

    @Test
    void verifyToken() {
    }

    @Test
    void getTokenInfo() throws InterruptedException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "oneStep");
        String token = JJWTUtils.getToken(map);
        Thread.sleep(6000);
        JJWTUtils.verifyToken(token);
    }
}