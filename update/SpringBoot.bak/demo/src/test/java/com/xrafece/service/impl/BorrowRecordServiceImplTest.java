package com.xrafece.service.impl;

import com.xrafece.entity.BorrowRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

/**
 * @author Xrafece
 */
@SpringBootTest
class BorrowRecordServiceImplTest {

    @Autowired
    private BorrowRecordServiceImpl borrowRecordService;

    @Test
    void updateRecordApprovalStatus() {
        borrowRecordService.updateRecordApprovalStatus(0, 3);
    }

    @Test
    void listRecordByDay() {
        List<BorrowRecord> borrowRecords = borrowRecordService.listRecordByDay(Date.valueOf("2020-09-24"));
        for (BorrowRecord borrowRecord : borrowRecords) {
            System.out.println(borrowRecord);
        }
    }
    @Test
    void listRecordByClassroom() {
        List<BorrowRecord> borrowRecords = borrowRecordService.listRecordByDay(Date.valueOf("2020-09-24"));
        for (BorrowRecord borrowRecord : borrowRecords) {
            System.out.println(borrowRecord);
        }
    }
}