package cn.java.requestblockqueue;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 作者: Jiang
 * 时间: 2021/7/31
 * 描述: 请求的参数校验类
 */
public class PrintProcessor extends Thread implements IRequestProcessor{
    //定义下一个处理器
    protected IRequestProcessor nextProcessor;

    public PrintProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    //阻塞队列容器，用来实现异步化
    private BlockingQueue<Request> blockingQueue = new LinkedBlockingQueue<>();

    @Override
    public void processorRequest(Request request) {
        System.out.println("print:"+ JSON.toJSONString(request));
        //something，做本处理器的业务处理
        nextProcessor.processorRequest(request);
    }

    @Override
    public void run() {
        //线程运行，从容器获取请求进行处理
        while(true){
            Request request = null;
            try {
                request = blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(null != request){
                //something，做本处理器的业务处理
                System.out.println("print:"+ JSON.toJSONString(request));
                nextProcessor.processorRequest(request);
            }
        }
    }
}
