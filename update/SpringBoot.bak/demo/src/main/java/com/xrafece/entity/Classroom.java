package com.xrafece.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Xrafece
 */
@Data
@AllArgsConstructor
public class Classroom {
    private Integer id;
    private String name;
    private Integer status;

    public Classroom(String name, Integer status) {
        this.name = name;
        this.status = status;
    }
}
