package cn.java.thread.semaphoreandexchanger.doubleSynBlock;

/**
 * @author: Jiang
 * @createTime: 2020-12-05 21:32
 * @description:
 */
public class ObjectService {
    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println("A begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end end=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB() {
        synchronized (this) {
            System.out.println("B begin time=" + System.currentTimeMillis());
            System.out.println("B end end=" + System.currentTimeMillis());
        }
    }
}

class ThreadA extends Thread {
    private ObjectService objectService;

    public ThreadA(ObjectService service) {
        super();
        this.objectService = service;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodA();
    }
}

class ThreadB extends Thread {
    private ObjectService objectService;

    public ThreadB(ObjectService service) {
        super();
        this.objectService = service;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodB();
    }
}

class Run {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("a");
        threadA.start();
        ThreadB threadB = new ThreadB(service);
        threadB.setName("b");
        threadB.start();

    }
}
