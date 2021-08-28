package cn.java.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-26 22:33
 * 描述:
 */
public class ConditionBlockedQueueExample {
    //阻塞队列的容器
    private List<String> items;
    //已经添加的元素个数
    private volatile  int size;
    //数组容量
    private volatile  int count;

    private Lock lock = new ReentrantLock();
    //让take方法阻塞
    private final Condition notEnpty = lock.newCondition();
    //放add方法阻塞
    private final Condition notFull = lock.newCondition();

    public ConditionBlockedQueueExample(int count){
        this.count = count;
        items = new ArrayList<>(count);//不存在扩容
    }
    //添加一个元素,并且阻塞添加
    public void put(String item) throws InterruptedException {
        lock.lock();
        try{
            if(size>=count){
                System.out.println("队列满了,需要阻塞!");
                notFull.await();
            }
            ++ size;
            items.add(item);
            notEnpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public String take(){
        lock.lock();
        try{
            if(size == 0){
                System.out.println("阻塞队列空了,需要等待才能取出数据!");
                notEnpty.await();
            }
            --size;
            String item = items.remove(0);
            notFull.signal();
            return item;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "";
    }
}
