package io.github.emryscheng.dynamic.thread.pool.sdk.domain;

import io.github.emryscheng.dynamic.thread.pool.sdk.domain.entity.ThreadPoolConfigEntity;

import java.util.List;

/**
 * 动态线程池服务
 *
 * @author chengpeng
 * @since 2024-12-04 21:28
 */
public interface IDynamicThreadPoolService {

    String getApplicationName();

    List<ThreadPoolConfigEntity> queryThreadPoolList();

    ThreadPoolConfigEntity queryThreadPoolConfigByName(String threadPoolName);

    void updateThreadPoolConfig(ThreadPoolConfigEntity threadPoolConfigEntity);

}
