package top.wycfight.spike.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import top.wycfight.spike.redis.KeyPrefix;
import top.wycfight.spike.service.RedisService;

/**
 * @author: wycfight@163.com
 * @description: redisService实现类
 * @create: 2019-12-03 21:47
 * @modify By:
 **/
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private JedisPool jedisPool;


    @Override
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            String result = jedis.get(realKey);
            T t = stringToBean(result, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    @Override
    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String result = beanToString(value);
            if (StringUtils.isBlank(result)) {
                return false;
            }
            String realKey = prefix.getPrefix() + key;
            jedis.set(realKey, result);
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    private <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    private <T> T stringToBean(String result, Class<T> clazz) {
        if (StringUtils.isBlank(result) || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(result);
        } else if (clazz == String.class) {
            return (T) result;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(result);
        } else {
            return JSON.toJavaObject(JSON.parseObject(result), clazz);
        }

    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }


}
