package com.xrafece.entry;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author Xrafece
 */
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Date birthday;
    private List<String> favorites;
    private Map<String, Integer> index;
    private Properties properties;
}
