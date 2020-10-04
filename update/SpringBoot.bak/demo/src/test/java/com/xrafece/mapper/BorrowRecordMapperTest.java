package com.xrafece.mapper;

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
class BorrowRecordMapperTest {

    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Test
    void listRecordByClassroom() {
        List<BorrowRecord> borrowRecords = borrowRecordMapper.listRecordByClassroom(Date.valueOf("2020-9-23"), "9#207");
        for (BorrowRecord borrowRecord : borrowRecords) {
            System.out.println(borrowRecord);

        }
    }
    @Test
    void listRecordByDay() {
        List<BorrowRecord> borrowRecords = borrowRecordMapper.listRecordByDay(Date.valueOf("2020-9-23"));
        for (BorrowRecord borrowRecord : borrowRecords) {
            System.out.println(borrowRecord);

        }
    }
}