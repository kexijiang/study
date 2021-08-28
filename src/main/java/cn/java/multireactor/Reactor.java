package cn.java.multireactor;

import cn.java.thread.semaphoreandexchanger.t2.Run;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-28 20:45
 * 描述:
 */
public class Reactor implements Runnable {

    final Selector selector;


    public Reactor(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            try{
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    Runnable runnable = (Runnable) key.attachment();
                    runnable.run();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
