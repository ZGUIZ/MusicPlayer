package com.zguiz.musicplayer;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.zguiz.musicplayer.config.TestConfig;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.kafka.common.utils.CopyOnWriteMap;
import org.mybatis.spring.annotation.MapperScannerRegistrar;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@NacosPropertySource(dataId = "public", autoRefreshed = true)
@SpringBootApplication
public class MusicplayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicplayerApplication.class, args);
        ExecutorService service = Executors.newCachedThreadPool();
        service.shutdown();
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

    }

}
