package top.wycfight.spike.service;

import top.wycfight.spike.dto.LoginDTO;
import top.wycfight.spike.entity.User;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: wycfight@163.com
 * @description: 用户Service
 * @create: 2019-11-29 07:19
 * @modify By:
 **/
public interface UserService {
    /**
     * 通过ID获取用户信息
     * @param username
     * @return
     */
    User getUserByName(String username);

    /**
     * 用户登录接口
     * @return
     */
    boolean login(HttpServletResponse response, LoginDTO loginDTO);

    /**
     * 根据Token获取用户细腻
     * @param token token
     * @return
     */
    User getByToken(HttpServletResponse response, String token);
}
