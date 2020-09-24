package com.xrafece.controller;

import com.xrafece.entity.BorrowRecord;
import com.xrafece.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Xrafece
 */
@RestController
@RequestMapping("record")
public class BorrowRecordController {

    @Autowired
    private BorrowRecordService borrowRecordService;

    @RequestMapping("all")
    public List<BorrowRecord> listRecords(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return borrowRecordService.listAllRecord();
    }
}
