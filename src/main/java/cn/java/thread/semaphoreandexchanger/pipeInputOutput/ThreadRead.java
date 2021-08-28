package cn.java.thread.semaphoreandexchanger.pipeInputOutput;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @ClassName: ThreadRead
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-15
 * @lastModificationTime: 2020-12-15
 */
public class ThreadRead extends Thread{
    private final ReadData read;
    private final PipedInputStream input;
    public ThreadRead(ReadData read,PipedInputStream input){
        super();
        this.read = read;
        this.input = input;
    }
    @Override
    public void run() {
        read.readMethod(input);
    }
}
class ThreadWrite  extends Thread{
    private final WriteData write;
    private final PipedOutputStream out;
    public ThreadWrite(WriteData write,PipedOutputStream out){
        super();
        this.write = write;
        this.out = out;
    }
    @Override
    public void run() {
        write.writeMethod(out);
    }
}