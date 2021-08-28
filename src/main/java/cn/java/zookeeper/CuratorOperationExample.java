package cn.java.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.StandardCharsets;

/**
 * 作者: Jiang
 * 时间: 2021/8/15
 * 描述:
 */
public class CuratorOperationExample {
    private static CuratorFramework curatorFramework;
    public CuratorOperationExample() {
        curatorFramework = CuratorFrameworkFactory.builder().connectionTimeoutMs(10000)
                .connectString("47.98.20.116:2181")
                //重试策略
                /*
                 * RetryNTimes：指定最大重试次数
                 * RetryOneTimes：重试一次
                 * RetryUnitlElapsed：一直重试直到达到规定时间
                 *
                 * */
                .retryPolicy(new ExponentialBackoffRetry(1000,3))
                .sessionTimeoutMs(10000)
                .build();
        curatorFramework.start();
    }
    public static void nodeCURD()throws Exception{
        System.out.println("开始针对节点的crud操作");
        String value = "hellow world";
        String node = curatorFramework.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/node",value.getBytes());
        System.out.println("节点创建成功！"+node);
        Stat stat = new Stat();//存储状态信息的对象
        byte[] data = curatorFramework.getData().storingStatIn(stat).forPath(node);
        System.out.println("节点value获取"+new String(data));

        stat = curatorFramework.setData().withVersion(stat.getVersion()).forPath("/node","1111111".getBytes(StandardCharsets.UTF_8));
        String result = new String(curatorFramework.getData().forPath(node));
        System.out.println("修改结点之后的数据："+result);
//        System.out.println("开始删除节点");
//        curatorFramework.delete().forPath(node);
//        Stat extsis = curatorFramework.getData().forPath(node);
//        if (extsis)
//        System.out.println(xi);
    }
}
