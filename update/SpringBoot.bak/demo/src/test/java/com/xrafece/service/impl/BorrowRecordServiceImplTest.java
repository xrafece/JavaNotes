package com.xrafece.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
}