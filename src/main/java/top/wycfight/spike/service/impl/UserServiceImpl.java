package top.wycfight.spike.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wycfight.spike.dao.UserDao;
import top.wycfight.spike.dto.LoginDTO;
import top.wycfight.spike.entity.User;
import top.wycfight.spike.service.UserService;
import top.wycfight.spike.util.MD5Util;

/**
 * @author: wycfight@163.com
 * @description: 用户Service接口实现类
 * @create: 2019-11-29 07:19
 * @modify By:
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public String login(LoginDTO loginDTO) {
        // 判断手机号是否存在
        String result = "";
        User user = userDao.getUserByName(loginDTO.getUsername());
        if (user == null) {
            result = "手机号不存在";
            return result;
        }
        String password = user.getPassword();
        String salt = user.getSalt();
        String dbPassword = MD5Util.formPassToDbPass(loginDTO.getPassword(), salt);
        if (password.equals(dbPassword)) {
            return "密码错误";
        }
        return "OK";
    }
}
