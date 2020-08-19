package com.xrafece.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xrafece.util.JJWTUtils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author Xrafece
 */
public class JJWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JJWTUtils.verifyToken(token);
            return true;
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            hashMap.put("msg", "token 过期");

        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
            hashMap.put("msg", "token 非法");

        } catch (MalformedJwtException e) {
            e.printStackTrace();
            hashMap.put("msg", "token 处理异常");
        } catch (SignatureException e) {
            e.printStackTrace();
            hashMap.put("msg", "token 不合法");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            hashMap.put("msg", "token 参数不合法");
        }
        hashMap.put("state", false);
        String json = new ObjectMapper().writeValueAsString(hashMap);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }

}
