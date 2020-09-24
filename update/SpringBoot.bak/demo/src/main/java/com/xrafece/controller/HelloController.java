package com.xrafece.controller;

import com.xrafece.entity.BorrowRecord;
import com.xrafece.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Xrafece
 */
@RestController
@RequestMapping("#")
public class HelloController {

    @Autowired
    private BorrowRecordService borrowRecordService;

    @Value("${controller.sc}")
    private String secret;

    @RequestMapping("hello")
    public String getTeacherUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println(secret);
        httpServletRequest.setAttribute("suer", "one");
        return "null";
    }

    @RequestMapping("list")
    public List<BorrowRecord> listRecords(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println(secret);
        return borrowRecordService.listAllRecord();
    }

    @RequestMapping("day")
    public List<BorrowRecord> listRecordsByday(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String day = "2020-06-03";
        Date parse = simpleDateFormat.parse(day);
        return borrowRecordService.listRecordByDay(parse);
    }
    @RequestMapping("id")
    public List<BorrowRecord> listRecordsByBorrowId(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ParseException {
        int id = 9009;
        return borrowRecordService.listRecordByBorrowId(id);
    }
}
