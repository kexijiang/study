package cn.java.requestblockqueue;

import lombok.Data;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-31 12:48
 * 描述: 实际请求对象
 */
@Data
public class Request {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
