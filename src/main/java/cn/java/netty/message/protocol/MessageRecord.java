package cn.java.netty.message.protocol;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 作者: Jiang
 * 时间: 2021/9/13
 * 描述: 消息报文类
 */
@Getter
@Setter
public class MessageRecord {
    private Header header;
    private Object body;

    @Override
    public String toString() {
        return "MessageRecord{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
