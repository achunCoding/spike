package top.wycfight.spike.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

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

    private String username;

    private String password;

    private String nickname;

    private String salt;

    private String head;

    private Date registerDate;

    private Date lastLoginDate;

    private Integer loginCount;


}
