package cn.java.netty.message.opcode;

/**
 * 作者: Jiang
 * 时间: 2021/9/13
 * 描述:
 */
public enum OpCode {
    REQ((byte) 0),
    RES((byte) 1),
    PING((byte) 2),
    PONG((byte) 3);

    private final byte code;

    OpCode(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }
}
