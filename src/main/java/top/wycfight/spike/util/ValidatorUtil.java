package top.wycfight.spike.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: wycfight@163.com
 * @description: 手机号验证
 * @create: 2019-12-05 21:25
 * @modify By:
 **/
public class ValidatorUtil {

    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    public static boolean isMobile(String phone) {
        if (StringUtils.isBlank(phone)) {
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(phone);
        return matcher.matches();
    }
}
