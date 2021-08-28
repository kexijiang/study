package cn.java.thread.semaphoreandexchanger.p_r_test;

/**
 * @ClassName: C
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-14
 * @lastModificationTime:2020-12-14
 */
public class C {
    private String lock;
    public C(String lock){
        super();
        this.lock = lock;
    }
    public void getValue(){
        try{
            synchronized (lock){
                if("".equals(ValueObject.value)){
                    lock.wait();
                }
                System.out.println("get 的值是"+ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
