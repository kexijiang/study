package cn.java.netty.message.protocol;

import lombok.Data;

/**
 * 作者: Jiang
 * 时间: 2021/9/13
 * 描述: 消息报文头
 */
@Data
public class Header {
    private long sessionId;//会话id，8字节
    private byte reqType;//消息类型，1字节
    private int length;//消息长度，4字节

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public byte getReqType() {
        return reqType;
    }

    public void setReqType(byte reqType) {
        this.reqType = reqType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Header{" +
                "sessionId=" + sessionId +
                ", reqType=" + reqType +
                ", length=" + length +
                '}';
    }
}
