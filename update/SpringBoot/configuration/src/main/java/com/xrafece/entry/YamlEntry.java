package com.xrafece.entry;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Xrafece
 */
@Data
// @Component
@ConfigurationProperties("yaml")
public class YamlEntry {
    private String str;
    private String specialStr;
    private Integer num;
    private Double doubleNum;
    private Date date;
    private List<Integer> numList;
    private Map<String, String> map;
    private Set<User> users;
}
