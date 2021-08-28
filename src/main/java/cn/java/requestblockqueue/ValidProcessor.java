package cn.java.requestblockqueue;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 作者: Jiang
 * 时间: 2021/7/31
 * 描述: 请求的参数校验类
 */
public class ValidProcessor extends Thread implements IRequestProcessor{
    //定义下一个处理器
    protected IRequestProcessor nextProcessor;

    public ValidProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }
    //阻塞队列容器，用来实现异步化
    private BlockingQueue<Request> blockingQueue = new LinkedBlockingQueue<>();

    @Override
    public void processorRequest(Request request) {
        //将请求对象放入容器
        blockingQueue.add(request);
    }

    @Override
    public void run() {
        //线程运行，从容器获取请求进行处理
        //如果当前线程执行take方法，队列为空，此线程会被阻塞，直到有元素可以被取出，此线程才会被唤醒继续执行，
        // 所以while（true）不会一直在运行，占用CPU运算资源
        while(true){
            Request request = null;
            try {
                request = blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(null != request){
                //something，做本处理器的业务处理
                System.out.println("valid:"+ JSON.toJSONString(request));
                nextProcessor.processorRequest(request);
            }
        }
    }
}
