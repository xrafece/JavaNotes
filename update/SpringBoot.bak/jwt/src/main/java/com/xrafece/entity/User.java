package com.xrafece.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Xrafece
 */
@Data
// set返回值为对象，开启链式set
@Accessors(chain = true)
public class User {
    private Integer id;
    private String username;
    private String password;
}
