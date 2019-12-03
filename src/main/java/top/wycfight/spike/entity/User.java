package top.wycfight.spike.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2019-11-30 09:48
 * @modify By:
 **/
@Getter
@Setter
@ToString
public class User implements Serializable {

    private Long id;


    private String name;


}
