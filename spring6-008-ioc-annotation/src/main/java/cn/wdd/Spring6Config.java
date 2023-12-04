package cn.wdd;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 编写一个类，代替spring框架的配置文件
 */
@Configuration
@ComponentScan({"cn.wdd.dao","cn.wdd.service"})
public class Spring6Config {
}
