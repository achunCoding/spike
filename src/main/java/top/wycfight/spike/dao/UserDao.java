package top.wycfight.spike.dao;

import org.apache.ibatis.annotations.Param;
import top.wycfight.spike.entity.User;

/**
 * @author: wycfight@163.com
 * @description: 用户Dao
 * @create: 2019-11-29 07:18
 * @modify By:
 **/
public interface UserDao {
    /**
     * 通过ID查询用户
     * @param username 用户名
     * @return 用户对象
     */
    User getUserByName(@Param("username") String username);
}
