package cn.java.thread.semaphoreandexchanger.setNewPropertiesLockOne;

class Userinfo {
    private String username;
    private String password;

    public Userinfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Userinfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
/**
 * @ClassName: Service
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-07
 * @lastModificationTime:2020-12-07
 */
public class Service {
    public void serviceMethodA(Userinfo user){
        synchronized (user){
            try {
                System.out.println(Thread.currentThread().getName());
                user.setUsername("aaaaaa");
                Thread.sleep(3000);
                System.out.println("end! time="+ System.currentTimeMillis());
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class ThreadA implements Runnable{
    private Service service;
    private Userinfo userinfo;
    public ThreadA(Service service,Userinfo userinfo) {
        super();
        this.service = service;
        this.userinfo = userinfo;
    }
    @Override
    public void run() {
        service.serviceMethodA(userinfo);
    }
}
class ThreadB implements Runnable{
    private Service service;
    private Userinfo userinfo;
    public ThreadB(Service service,Userinfo userinfo) {
        super();
        this.service = service;
        this.userinfo = userinfo;
    }
    @Override
    public void run() {
        service.serviceMethodA(userinfo);
    }
}
class Run{
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Userinfo userinfo = new Userinfo();
        ThreadA a = new ThreadA(service,userinfo);
        Thread t1 = new Thread(a,"t1");
        t1.start();
        Thread.sleep(50);
        ThreadB b = new ThreadB(service,userinfo);
        Thread t2 = new Thread(b, "cn/java/thread/t2");
        t2.start();
    }
}
