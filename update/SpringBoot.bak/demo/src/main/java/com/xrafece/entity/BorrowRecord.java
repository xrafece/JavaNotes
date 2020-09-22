package com.xrafece.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Xrafece
 */
@Data
public class BorrowRecord {
    private Integer id;
    private String borrowInform;
    private Integer borrowId;
    private String classroom;
    private Timestamp startTime;
    private Timestamp endTime;
    private String reason;
    private Integer approvalStatus;
}
