package cn.java.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * 作者: Jiang
 * 时间: 2021/8/15
 * 描述:
 */
public class CuratorMain {
    public static void main(String[] args) throws Exception {
        CuratorOperationExample curatorOperationExample = new CuratorOperationExample();
        curatorOperationExample.nodeCURD();
    }
}
