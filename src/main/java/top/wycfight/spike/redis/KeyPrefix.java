package top.wycfight.spike.redis;

/**
 * @author: wycfight@163.com
 * @description: redis 前缀Key 和 过期时间
 * @create: 2019-12-04 07:41
 * @modify By:
 **/
public interface KeyPrefix {
    /**
     * 过期时间 默认0 代表永不过期
     * @return
     */
    int expireSeconds();

    /**
     * 前缀
     * @return
     */
    String getPrefix();
}
