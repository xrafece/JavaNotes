package com.xrafece.service.impl;

import com.xrafece.entity.BorrowRecord;
import com.xrafece.mapper.BorrowRecordMapper;
import com.xrafece.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Xrafece
 */
@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {

    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Override
    public List<BorrowRecord> listAllRecord() {
        return borrowRecordMapper.listAllRecord();
    }

    @Override
    public List<BorrowRecord> listRecordByDay(Date day) {
        return borrowRecordMapper.listRecordByDay(day);
    }

    @Override
    public List<BorrowRecord> listRecordByBorrowId(Integer borrowId) {
        return borrowRecordMapper.listRecordByBorrowId(borrowId);
    }

    @Override
    public void updateRecordApprovalStatus(Integer id, Integer approvalStatus) {
        borrowRecordMapper.updateRecordApprovalStatus(id, approvalStatus);
    }
}
