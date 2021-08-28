package cn.java.thread.semaphoreandexchanger.wait_notify_service;

/**
 * @ClassName: MyThreadA
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-11
 * @lastModificationTime:2020-12-11
 */
public class MyThreadA extends Thread{
    private MyService service;
    public MyThreadA(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMethod();
    }
}

