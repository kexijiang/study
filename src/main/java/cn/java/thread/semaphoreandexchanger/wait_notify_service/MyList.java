package cn.java.thread.semaphoreandexchanger.wait_notify_service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MyList
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-11
 * @lastModificationTime:2020-12-11
 */
public class MyList {
    volatile private List list = new ArrayList<>();
    public void add(){
        list.add("anyString");
    }
    public int size(){
        return list.size();
    }
}
