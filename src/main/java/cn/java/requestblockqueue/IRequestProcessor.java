package cn.java.requestblockqueue;

import org.bouncycastle.cert.ocsp.Req;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-31 12:49
 * 描述: 请求的抽象接口
 */
public interface IRequestProcessor {
    void processorRequest(Request request);
}
