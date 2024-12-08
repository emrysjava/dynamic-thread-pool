package io.github.emryscheng.dynamic.thread.pool.sdk.registry;

import io.github.emryscheng.dynamic.thread.pool.sdk.domain.entity.ThreadPoolConfigEntity;

import java.util.List;

/**
 * 注册中心接口
 *
 * @author chengpeng
 * @since 2024-12-04 21:26
 */
public interface IRegistry {

    void reportThreadPool(String applicationName, List<ThreadPoolConfigEntity> threadPoolEntities);

    void reportThreadPoolConfigParameter(ThreadPoolConfigEntity threadPoolConfigEntity);

}

