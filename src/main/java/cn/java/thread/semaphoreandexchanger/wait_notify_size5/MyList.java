package cn.java.thread.semaphoreandexchanger.wait_notify_size5;

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
    private static List list = new ArrayList<>();
    public static void add(){
        list.add("anyString");
    }
    public static int size(){
        return list.size();
    }
}
