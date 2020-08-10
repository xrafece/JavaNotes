package com.xrafece.entry;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Xrafece
 */
// 注解作用：自动添加 Getter Setter toString equal hashcode 无参构造方法
// 此处添加是为了 controller 里面 ResponseBody 返回值提供 set 和 get ，参数注入时是用不到的。
@Data
@ConfigurationProperties("properties")
@ConstructorBinding
public class PropertiesEntry {
    private String name;
    private Integer port;
    private List<String> file;

    public PropertiesEntry(String name, Integer port, List<String> file) {
        System.out.println("ConstructorBinging annotation run this constructor method by default.");
        this.name = name;
        this.port = port;
        this.file = file;
    }

    // error: com.xrafece.entry.PropertiesEntry has more than one @ConstructorBinding constructor
    // @ConstructorBinding
    // public PropertiesEntry(String name, List<String> file) {
    //     System.out.println("ConstructorBinging annotation run this constructor method by default.");
    //     this.name = name;
    //     this.port = port;
    //     this.file = file;
    // }

}
