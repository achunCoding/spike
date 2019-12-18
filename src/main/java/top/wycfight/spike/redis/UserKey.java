package top.wycfight.spike.redis;

/**
 * @author: wycfight@163.com
 * @description: 用户Key
 * @create: 2019-12-04 07:58
 * @modify By:
 **/
public class UserKey extends BasePrefix {

    private static int expireSeconds = 3600;

    private UserKey(String prefix) {
        super(prefix);
    }

    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds,prefix);
    }


    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
    public static UserKey token = new UserKey(expireSeconds,"token");
}
