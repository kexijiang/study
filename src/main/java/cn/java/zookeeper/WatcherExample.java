package cn.java.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * 作者: Jiang
 * 时间: 2021/8/28
 * 描述:
 */
public class WatcherExample {
    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {//全局监听
                    System.out.println("event.type:"+event.getType());
                }
            });
            zooKeeper.exists("/watcher",true);
            zooKeeper.setData("/watcher","sss".getBytes(),-1);
            System.in.read();
        } catch (IOException | KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
