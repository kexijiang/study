package cn.java.redisclient;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-21 21:18
 * 描述:
 */
public class CommandConstant {

    public static final String START = "*";
    public static final String LENGTH = "$";
    public static final String LINE = "\r\n";

    public enum CommandEnum{
        SET,
        GET
    }

}
