package jvm.加载机制.类加载器.不同类加载器下的相等测试;

import java.io.InputStream;

/**
 * 类加载器与instance关键字演示
 */
public class ClassLoaderTest {

    /**
     * 构建一个简单的类构造器去加载统一路径下的class文件
     * 结果返回false是因为虚拟机中存在了两个ClassLoaderTest类，
     * 一个是用系统应用程序加载器加载的，另外一个是我们自定义的类加载器加载的
     * 虽然来自同一个从class文件，但依然是两个独立的类，所以做类型检查时为false
     * @param args
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader mLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is==null)
                        return super.loadClass(name);
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch (Exception e){
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = mLoader.loadClass("jvm.加载机制.类加载器.不同类加载器下的相等测试.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);
    }

}
