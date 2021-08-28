package cn.java.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author: Jiang
 * @createTime: 2021-07-03 19:37
 * @description:
 */
public class KXClassLoader extends ClassLoader {

    private final File classPathFile;
    public KXClassLoader(){
        String classPath = KXClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = KXClassLoader.class.getPackage().getName()+"." + name;
        if(classPathFile!=null){
            /*将类文件读取为一个文件对象*/
            File classFile = new File(classPathFile,name.replace("\\.","/") + ".class");
            /*判断是否读取成功*/
            if(classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                /*将文件内容读取到缓存中*/
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = in.read(buffer))!=-1){
                        out.write(buffer, 0, len);
                    }
                    /*将缓存中的文件内容传给定义类的方法,返回该类对象*/
                    return defineClass(className,out.toByteArray(),0,out.size());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
        return super.findClass(name);
    }
}
