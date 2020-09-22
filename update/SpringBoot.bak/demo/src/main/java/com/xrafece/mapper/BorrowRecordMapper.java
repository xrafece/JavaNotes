package com.xrafece.mapper;

import com.xrafece.entity.BorrowRecord;

import java.util.Date;
import java.util.List;

/**
 * @author Xrafece
 */
public interface BorrowRecordMapper {
    List<BorrowRecord> listAllRecord();

    List<BorrowRecord> listRecordByDay(Date day);

    List<BorrowRecord> listRecordByBorrowId(Integer borrowId);

    void updateRecordApprovalStatus(Integer id, Integer approvalStatus);
}
