package top.wycfight.spike.redis;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2019-12-04 07:43
 * @modify By:
 **/
public abstract class BasePrefix implements KeyPrefix {

    public BasePrefix(String prefix) {
        this(0, prefix);
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    private int expireSeconds;

    private String prefix;

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String simpleName = getClass().getSimpleName();
        return simpleName + ":" + simpleName;
    }
}
