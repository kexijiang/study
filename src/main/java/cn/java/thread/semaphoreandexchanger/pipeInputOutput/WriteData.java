package cn.java.thread.semaphoreandexchanger.pipeInputOutput;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @ClassName: WriteData
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-15
 * @lastModificationTime: 2020-12-15
 */
public class WriteData {
    public void writeMethod(PipedOutputStream out){
        try{
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i+1);
                out.write(outData.getBytes());
                System.out.println(outData);
            }
            System.out.println();
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
