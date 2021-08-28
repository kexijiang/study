package cn.java.thread.semaphoreandexchanger.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @ClassName: ReadData
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-15
 * @lastModificationTime: 2020-12-15
 */
public class ReadData {
    public void readMethod(PipedInputStream input){
        try{
            System.out.println("read :");
            byte[] byteArray = new byte[20];
            //char[] charArray = new char[20];
            int readLength = input.read(byteArray);
            while(readLength != -1){
                String newData = new String(byteArray,0,readLength);
                System.out.println(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
