package top.wycfight.spike.service;

import top.wycfight.spike.redis.KeyPrefix;

/**
 * @author: wycfight@163.com
 * @description: redisService
 * @create: 2019-12-03 21:46
 * @modify By:
 **/
public interface RedisService {
    /**
     * redisGet数据
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T get(KeyPrefix prefix, String key, Class<T> clazz);

    /**
     * set 数据
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    <T> boolean set(KeyPrefix prefix, String key, T value);

    /**
     * 判断Key是否存在
     * @param prefix 前缀
     * @param key key
     * @return
     */
    boolean exists(KeyPrefix prefix, String key);

    /**
     * 增加
     * @param prefix
     * @param key
     * @return
     */
    Long incr(KeyPrefix prefix, String key);

    /**
     * 减少
     * @param prefix
     * @param key
     * @return
     */
    Long decr(KeyPrefix prefix, String key);
}
