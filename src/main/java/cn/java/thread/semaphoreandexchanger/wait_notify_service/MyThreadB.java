package cn.java.thread.semaphoreandexchanger.wait_notify_service;

/**
 * @ClassName: MyThreadB
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-11
 * @lastModificationTime:2020-12-11
 */
public class MyThreadB extends Thread{
    private MyService service;
    public MyThreadB(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.notifyMethod();
    }
}
