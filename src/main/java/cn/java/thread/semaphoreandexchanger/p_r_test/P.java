package cn.java.thread.semaphoreandexchanger.p_r_test;

/**
 * @ClassName: P
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-14
 * @lastModificationTime:2020-12-14
 */
public class P {
    private String lock;
    public P(String lock){
        super();
        this.lock = lock;
    }
    public void setValue(){
        try{
            synchronized (lock){
                if(!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value = System.currentTimeMillis()+"_" + System.nanoTime();
                System.out.println("set 的值是"+value);
                ValueObject.value = value;
                lock.notify();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
