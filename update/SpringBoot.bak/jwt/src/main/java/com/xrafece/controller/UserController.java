package com.xrafece.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.xrafece.entity.User;
import com.xrafece.service.impl.UserServiceImpl;
import com.xrafece.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xrafece
 */
@RestController
@Slf4j
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("login")
    public Map<String, Object> login(User user) {
        HashMap<String, Object> map = new HashMap<>();
        log.info("用户名：[{}]", user.getUsername());
        log.info("密码：[{}]", user.getPassword());
        try {
            User login = userServiceImpl.login(user);
            HashMap<String, String> payload = new HashMap<>();
            payload.put("id", login.getId().toString());
            payload.put("username", login.getUsername());

            String token = JWTUtils.getToken(payload);

            map.put("state", true);
            map.put("msg", "认证成功");
            map.put("token", token);
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @PostMapping("test")
    public Map<String, Object> test(HttpServletRequest request) {
        String token = request.getHeader("token");
        log.info("token: [{}]", token);
        DecodedJWT tokenInfo = JWTUtils.getTokenInfo(token);
        log.info("id：[{}]", tokenInfo.getClaim("id").asString());
        log.info("用户名：[{}]", tokenInfo.getClaim("username").as(String.class));
        HashMap<String, Object> map = new HashMap<>();
        map.put("state", true);
        map.put("msg", "token正确，请求成功");
        return map;
    }
}
