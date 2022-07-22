package com.lixin.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {

    private static final Integer CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;

    private static final Integer MAX_POOL_SIZE = 200;

    /**
     * 允许线程空闲时间（单位：默认为秒）
     */
    private static final int KEEP_ALIVE_TIME = 10;
    /**
     * 缓冲队列大小
     */
    private static final int QUEUE_CAPACITY = 200;
    /**
     * 线程池名前缀
     */
    private static final String THREAD_NAME_PREFIX = "Async-Service-";


    @Bean
    public ThreadPoolTaskExecutor asyncExecutor() {
        ThreadPoolTaskExecutor asyncTask = new ThreadPoolTaskExecutor();
        asyncTask.setCorePoolSize(CORE_POOL_SIZE);
        asyncTask.setMaxPoolSize(MAX_POOL_SIZE);
        asyncTask.setQueueCapacity(QUEUE_CAPACITY);
        asyncTask.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        asyncTask.setThreadNamePrefix(THREAD_NAME_PREFIX);
        asyncTask.initialize();
        return asyncTask;
    }
}
