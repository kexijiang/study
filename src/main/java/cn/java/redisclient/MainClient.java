package cn.java.redisclient;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
public class MainClient {
    public static void main(String[] args) {
        CustomerRedisClient customerRedisClient=new CustomerRedisClient("49.234.214.32",7984);

        System.out.println(customerRedisClient.set("customer","Define"));
        System.out.println(customerRedisClient.get("customer"));
    }
}
