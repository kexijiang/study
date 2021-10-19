package cn.java.spring.project.entity;
import org.springframework.stereotype.Component;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述: 案例对象
 */
@Component
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private void start() {
        System.out.println("person is start.");
    }

    private void destroy() {
        System.out.println("person is destroy.");
    }
}
