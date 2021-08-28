package cn.java.thread.semaphoreandexchanger.test1;

/**
 * @ClassName: Test1
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-11
 * @lastModificationTime:2020-12-11
 */
public class Test1 {
    public static void main(String[] args) {
        try{
            String newString = new String("");
            newString.wait();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
