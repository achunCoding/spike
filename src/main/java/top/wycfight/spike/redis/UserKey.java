package top.wycfight.spike.redis;

/**
 * @author: wycfight@163.com
 * @description: 用户Key
 * @create: 2019-12-04 07:58
 * @modify By:
 **/
public class UserKey extends BasePrefix {

    private UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
