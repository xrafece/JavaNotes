package com.xrafece.request.entity;

import lombok.Data;

/**
 * @author Xrafece
 */
@Data
public class One {
    private Integer id;
    private String name;

    public One(String name) {
        this.name = name;
    }
}
