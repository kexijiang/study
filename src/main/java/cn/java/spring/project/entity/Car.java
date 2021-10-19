package cn.java.spring.project.entity;

/**
 * @author kxjiang
 * 时间: 2021/10/19
 * 描述: 汽车类
 */
public class Car {
    public Car() {
        System.out.println("调用构造方法！");
    }

    public void addOil(){
        System.out.println("加油！");
    }

    public void run(){
        System.out.println("正在开车！");
    }
    public void close(){
        System.out.println("熄火！");
    }
}
