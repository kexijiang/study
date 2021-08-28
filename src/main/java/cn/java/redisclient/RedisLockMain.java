package cn.java.redisclient;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-24 20:15
 * 描述:
 */
public class RedisLockMain {
    private static RedissonClient redissonClient;
    static{
        Config config = new Config();
        config.useSingleServer().setAddress("redis://49.234.214.32:7984");
        redissonClient = Redisson.create(config);
    }

    public static void main(String[] args) throws InterruptedException {
        RLock lock =  redissonClient.getLock("updateRepo");

        if(lock.tryLock(1000, TimeUnit.SECONDS)){//返回true，表示获得锁成功
            System.out.println("获取锁成功！");
        }else{
            System.out.println("获取锁失败！");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}
