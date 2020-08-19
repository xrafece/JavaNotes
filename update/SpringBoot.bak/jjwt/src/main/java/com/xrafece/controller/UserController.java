package com.xrafece.controller;

import com.xrafece.entity.User;
import com.xrafece.service.UserService;
import com.xrafece.util.JJWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xrafece
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public Map login(User user) {
        HashMap<String, Object> map = new HashMap<>();
        log.info("用户名：[{}]", user.getUsername());
        log.info("密码：[{}]", user.getPassword());
        if (userService.checkLogin(user)) {

            HashMap<String, Object> claims = new HashMap<>();
            claims.put("username", user.getUsername());
            String token = JJWTUtils.getToken(claims);

            map.put("state", true);
            map.put("msg", "认证成功");
            map.put("token", token);
        } else {
            map.put("state", false);
            map.put("mag", "认证失败， 密码错误");
        }
        return map;
    }

    @RequestMapping("test")
    public Map testToken(HttpServletRequest httpServletRequest) {
        HashMap<String, Object> map = new HashMap<>();
        String token = httpServletRequest.getHeader("token");
        log.info("token: [{}]", token);
        map.put("state", true);
        map.put("msg", "token 合法");
        return map;
    }
}