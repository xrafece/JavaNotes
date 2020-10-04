package com.xrafece.mapper;

import com.xrafece.entity.BorrowRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author Xrafece
 */
public interface BorrowRecordMapper {
    List<BorrowRecord> listAllRecord();

    List<BorrowRecord> listRecord(Integer startIndex, Integer pageSize);

    List<BorrowRecord> listRecordByDay(Date day);

    List<BorrowRecord> listRecordByClassroom(@Param("day") Date day, @Param("classroom") String classroom);

    List<BorrowRecord> listRecordByBorrowId(Integer borrowId);

    void updateRecordApprovalStatus(Integer id, Integer approvalStatus);

    void insertRecord(BorrowRecord borrowRecord);

    void removeRecord(BorrowRecord borrowRecord);

    void removeRecordById(Integer id);
}
