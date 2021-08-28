package cn.java.redisclient;

import cn.java.lock.ConditionDemoNotify;

import java.nio.charset.StandardCharsets;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-21 21:22
 * 描述:
 */
public class CustomerRedisClient {

    private CustomerRedisClientSocket customerRedisClientSocket;

    public CustomerRedisClient(String ip,int port){
        customerRedisClientSocket = new CustomerRedisClientSocket(ip,port);
    }
    public String set(String key,String value){
        customerRedisClientSocket.send(convertToCommand(CommandConstant.CommandEnum.SET,key.getBytes(StandardCharsets.UTF_8),value.getBytes(StandardCharsets.UTF_8)));
        return customerRedisClientSocket.read();//在等到返回结果前,是阻塞的,
    }
    public String get(String key){
        customerRedisClientSocket.send(convertToCommand(CommandConstant.CommandEnum.GET,key.getBytes()));
        return customerRedisClientSocket.read();
    }
    public static String convertToCommand(CommandConstant.CommandEnum commandEnum,byte[]... bytes){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CommandConstant.START).append(bytes.length+1).append(CommandConstant.LENGTH);
        stringBuilder.append(CommandConstant.LENGTH).append(commandEnum.toString().length()).append(CommandConstant.LENGTH);
        stringBuilder.append(commandEnum.toString().length()).append(CommandConstant.LINE);
        for(byte[] by:bytes){
            stringBuilder.append(CommandConstant.LENGTH).append(by.length).append(CommandConstant.LINE);
            stringBuilder.append(new String(by)).append(CommandConstant.LINE);
        }
        return stringBuilder.toString();
    }

}
