package cn.java.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author: Jiang
 * @createTime: 2021-07-03 19:35
 * @description:
 */
public class KXProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(KXClassLoader classLoader, Class<?>[] interfaces, KXInvocationHandler h) {
        try {
            /*1.动态生成源码,.java文件*/
            String src = generateSrc(interfaces);
            System.out.println(src);
            /*2.java文件输出到磁盘,保存为文件$Proxy0.java*/
            String filePath = KXProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();
            /*3.将java文件编译为$Proxy.class*/
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            /*4.将生成的.class文件加载到JVM中*/
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(KXInvocationHandler.class);
            /*5.返回新的代理对象*/
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package cn.java.proxy;" + ln);
        sb.append("import cn.java.client.IPerson;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public final class $Proxy0 implements ").append(interfaces[0].getName()).append("{").append(ln);
        sb.append("KXInvocationHandler h;" + ln);
        sb.append("public $Proxy0(KXInvocationHandler h){" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);

        for (Method m : interfaces[0].getMethods()) {
            Class<?>[] params = m.getParameterTypes();

            StringBuilder paramNames = new StringBuilder();
            StringBuilder paramValues = new StringBuilder();
            StringBuilder paramClasses = new StringBuilder();
            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                paramClasses.append(clazz.getName() + ".class");
                if(i > 0 && i < params.length-1){
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }
            sb.append("public ").append(m.getReturnType().getName()).append(" ").append(m.getName()).append("() {").append(ln);
            sb.append("try{" + ln);
            sb.append("Method m = ").append(interfaces[0].getName()).append(".class.getMethod(\"").append(m.getName()).append("\",new Class[]{});").append(ln);
            /*调用代理接口中的反射方法*/
            sb.append("this.h.invoke(this,m,new Object[]{});" + ln);
            sb.append("return ;" + ln);
            sb.append("}catch(Exception e){System.out.println(e);}" + ln);
            sb.append("catch (Throwable throwable) {\n" +
                    "            throwable.printStackTrace();\n" +
                    "        }" + ln);
            sb.append("}" + ln);
            sb.append("}" + ln);
        }


        return sb.toString();

    }
}
