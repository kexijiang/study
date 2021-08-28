package cn.java.thread.semaphoreandexchanger.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @ClassName: Run
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-15
 * @lastModificationTime:2020-12-15
 */
public class Run {
    public static void main(String[] args) {
        try{
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            pipedOutputStream.connect(pipedInputStream);
            ThreadRead threadRead = new ThreadRead(readData,pipedInputStream);
            threadRead.start();
            Thread.sleep(2000);
            ThreadWrite threadWrite = new ThreadWrite(writeData, pipedOutputStream);
            threadWrite.start();
        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
