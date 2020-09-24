package com.xrafece.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Xrafece
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Period {
    private Date startTime;
    private Date endTime;
}
