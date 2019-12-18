package top.wycfight.spike.util;

import java.util.UUID;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2019-12-10 21:52
 * @modify By:
 **/
public class UUIDUtil {
    public static String generUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
