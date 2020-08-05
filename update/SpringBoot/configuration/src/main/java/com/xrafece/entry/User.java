package com.xrafece.entry;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Xrafece
 */
@Data
public class User {
    private Integer id;
    private String name;
}
