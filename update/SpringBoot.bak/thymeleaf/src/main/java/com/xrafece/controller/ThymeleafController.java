package com.xrafece.controller;

import cn.yiban.open.Authorize;
import com.xrafece.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Xrafece
 */
@Controller
public class ThymeleafController {
    @RequestMapping("hello")
    public String helloPage(Model model) {
        model.addAttribute("one", "This is a test");
        return "hello";
    }
    @GetMapping
    public void getYiBanAuthorize(HttpServletResponse httpServletResponse) throws IOException {
        Authorize authorize = new Authorize(Constant.YIBAN_APP_ID, Constant.YIBAN_APP_SECRET);
        String url = authorize.forwardurl(Constant.YIBAN_APP_REDIRECT_URI, String.valueOf(new Date().getTime()), Authorize.DISPLAY_TAG_T.MOBILE);
        httpServletResponse.sendRedirect(url);
    }
}
