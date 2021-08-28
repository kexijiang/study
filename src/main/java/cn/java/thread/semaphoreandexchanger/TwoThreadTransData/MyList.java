package cn.java.thread.semaphoreandexchanger.TwoThreadTransData;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MyList
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-08
 * @lastModificationTime: 2020-12-08
 */
public class MyList {
    volatile private List<String> list = new ArrayList<>();
    public void add(){
        list.add("kxjiang");
    }
    public int size(){
        return list.size();
    }
}
class ThreadA extends Thread{
    private MyList list;
    public ThreadA(MyList list){
        super();
        this.list=list;
    }
    @Override
    public void run() {
        try{
            for (int i = 0; i < 10; i++) {
                list.add();
                System.out.println("添加了"+(i+1)+"个元素");
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
class ThreadB extends Thread{
    private MyList list;
    public ThreadB(MyList list){
        super();
        this.list=list;
    }
    @Override
    public void run() {
        try{
            while(true){
                if(list.size()==5){
                    System.out.println("==5了,线程b要退出了!");
                    throw new InterruptedException();
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Test{
    public static void main(String[] args) {
        MyList myList = new MyList();
        ThreadA a = new ThreadA(myList);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(myList);
        b.setName("B");
        b.start();
    }
}