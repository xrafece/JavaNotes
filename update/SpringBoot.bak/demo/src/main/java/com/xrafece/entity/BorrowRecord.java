package com.xrafece.entity;

import lombok.Data;

import java.sql.Time;
import java.sql.Date;

/**
 * @author Xrafece
 */
@Data
public class BorrowRecord {
    private Integer id;
    private String borrowInform;
    private Integer borrowId;
    private String classroom;
    private Date borrowDate;
    private Time startTime;
    private Time endTime;
    private String reason;
    private Integer approvalStatus;
}
