package top.wycfight.spike.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: wycfight@163.com
 * @description: mybatis配置
 * @create: 2019-11-29 07:20
 * @modify By:
 **/
@Configuration
@EnableTransactionManagement
@MapperScan("top.wycfight.spike.dao")
public class MyBatisConfig {
}
