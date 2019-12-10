package top.wycfight.spike.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import top.wycfight.spike.validator.IsMobile;

import javax.validation.constraints.NotNull;

/**
 * @author: wycfight@163.com
 * @description: 登录请求参数
 * @create: 2019-12-05 21:09
 * @modify By:
 **/
@Getter
@Setter
@ToString
public class LoginDTO {

    @NotNull
    @IsMobile
    public String username;

    @NotNull
    @Length(min = 32)
    public String password;
}
