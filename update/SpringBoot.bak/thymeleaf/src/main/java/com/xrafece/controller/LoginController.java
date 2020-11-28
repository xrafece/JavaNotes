package com.xrafece.controller;

import cn.yiban.open.Authorize;
import cn.yiban.open.FrameUtil;
import cn.yiban.open.common.User;
import com.xrafece.util.Constant;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @author Xrafece
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping("yiban")
    public String yiban(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        FrameUtil frameUtil = new FrameUtil(request, response, Constant.YIBAN_APP_ID, Constant.YIBAN_APP_SECRET, Constant.YIBAN_APP_REDIRECT_URI);
        String token = (String) session.getAttribute("token");
        if (token == null) {
            if (frameUtil.perform()) {
                String userId = frameUtil.getUserId();
                String username = frameUtil.getUserName();
                String accessToken = frameUtil.getAccessToken();

                System.out.println(accessToken + "  oon");
                session.setAttribute("token", accessToken);
                model.addAttribute("userid", userId);
                model.addAttribute("token", accessToken);
                model.addAttribute("username", username);
                User user = new User(accessToken);
                System.out.println(user.me());
                JSONObject json = JSONObject.fromObject(user.me());
                JSONObject info = json.getJSONObject("info");
                System.out.println(info);
                System.out.println(info.getString("yb_username"));
                System.out.println(info.getString("yb_userhead"));
                model.addAttribute("headUrl", info.getString("yb_userhead"));
            }
        }
        // request.getRequestDispatcher("/hello").forward(request, response);
        return "index";
    }

    @GetMapping
    public void testApi(HttpServletResponse httpServletResponse) throws IOException {
        Authorize authorize = new Authorize(Constant.YIBAN_APP_ID, Constant.YIBAN_APP_SECRET);
        String url = authorize.forwardurl(Constant.YIBAN_APP_REDIRECT_URI, new Date().toString(), Authorize.DISPLAY_TAG_T.MOBILE);
        httpServletResponse.sendRedirect(url);
    }

}
