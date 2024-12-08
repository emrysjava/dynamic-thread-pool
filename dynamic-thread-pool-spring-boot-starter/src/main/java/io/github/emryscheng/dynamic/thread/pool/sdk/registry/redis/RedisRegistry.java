package io.github.emryscheng.dynamic.thread.pool.sdk.registry.redis;

import io.github.emryscheng.dynamic.thread.pool.sdk.domain.entity.ThreadPoolConfigEntity;
import io.github.emryscheng.dynamic.thread.pool.sdk.em.RegistryEnum;
import io.github.emryscheng.dynamic.thread.pool.sdk.registry.IRegistry;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

import java.time.Duration;
import java.util.List;

/**
 * Redis 注册中心
 *
 * @author chengpeng
 * @since 2024-12-04 21:29
 */
public class RedisRegistry implements IRegistry {

    private final RedissonClient redissonClient;

    public RedisRegistry(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public void reportThreadPool(String applicationName, List<ThreadPoolConfigEntity> threadPoolEntities) {
        // RList<ThreadPoolConfigEntity> list = redissonClient.getList(RegistryEnum.THREAD_POOL_CONFIG_LIST_KEY.getKey());
        RMap<String, List<ThreadPoolConfigEntity>> map = redissonClient.getMap(RegistryEnum.THREAD_POOL_CONFIG_LIST_KEY.getKey());
        map.put(applicationName, threadPoolEntities);
        // int size = list.size();
        // for (int i = 0; i < size; i++) {
        //     ThreadPoolConfigEntity entity = list.get(i);
        //     if (Objects.nonNull(entity) && Objects.equals(applicationName, entity.getAppName())) {
        //         list.remove(entity, i);
        //         i--;
        //         size--;
        //     }
        // }
        // for (ThreadPoolConfigEntity entity : threadPoolEntities) {
        //     if (Objects.equals(applicationName, entity.getAppName())) {
        //         list.add(entity);
        //     }
        // }
    }

    @Override
    public void reportThreadPoolConfigParameter(ThreadPoolConfigEntity threadPoolConfigEntity) {
        String cacheKey = RegistryEnum.THREAD_POOL_CONFIG_PARAMETER_LIST_KEY.getKey() + "_" + threadPoolConfigEntity.getAppName() + "_" + threadPoolConfigEntity.getThreadPoolName();
        RBucket<ThreadPoolConfigEntity> bucket = redissonClient.getBucket(cacheKey);
        bucket.set(threadPoolConfigEntity, Duration.ofDays(30));
    }

}

