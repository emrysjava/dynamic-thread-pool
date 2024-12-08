package io.github.emryscheng.dynamic.thread.pool;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动器
 *
 * @author chengpeng
 * @since 2024-12-07 17:42
 */
@SpringBootApplication
@Configurable
public class DynamicThreadPoolAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicThreadPoolAdminApplication.class);
    }

}
