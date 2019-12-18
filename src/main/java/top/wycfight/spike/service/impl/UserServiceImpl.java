package top.wycfight.spike.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wycfight.spike.dao.UserDao;
import top.wycfight.spike.dto.LoginDTO;
import top.wycfight.spike.entity.User;
import top.wycfight.spike.exception.GlobleException;
import top.wycfight.spike.redis.UserKey;
import top.wycfight.spike.service.RedisService;
import top.wycfight.spike.service.UserService;
import top.wycfight.spike.util.MD5Util;
import top.wycfight.spike.util.UUIDUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: wycfight@163.com
 * @description: 用户Service接口实现类
 * @create: 2019-11-29 07:19
 * @modify By:
 **/
@Service
public class UserServiceImpl implements UserService {

    public static final String COOKIE_NAME = "token";

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisService redisService;

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public boolean login(HttpServletResponse response, LoginDTO loginDTO) {
        // 判断手机号是否存在

        User user = userDao.getUserByName(loginDTO.getUsername());
        if (user == null) {
            throw new GlobleException("手机号不存在");
        }
        String password = user.getPassword();
        String salt = user.getSalt();
        String dbPassword = MD5Util.formPassToDbPass(loginDTO.getPassword(), salt);
        if (!password.equals(dbPassword)) {
            throw new GlobleException("密码错误");
        }
        String token = UUIDUtil.generUUID();
        addCookie(response, user, token);
        return true;
    }

    @Override
    public User getByToken(HttpServletResponse response, String token) {
        User user = redisService.get(UserKey.token, token, User.class);
        if (user != null) {
            addCookie(response, user, token);
        }
        return user;
    }

    private void addCookie(HttpServletResponse response, User user, String token) {
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME, token);
        cookie.setMaxAge(UserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
