package com.wdd.client;

import com.wdd.annotation.Component;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComponetScan {
    public static void main(String[] args){
        Map<String,Object> beanMap = new HashMap<>();
        //只知道一个包的名字，扫描这个包下所有的类，当这个类上有@Component注解的时候，实例化该对象，然后放到Map集合中
        String packageName = "com.wdd.bean";
        //开始写扫描程序
        //   . 在正则表达式中代表任意字符，这里的 "." 必须是一个普通的字符，不能是正则表达式中的点
        // 使用\.  代表一个普通的.
        String packagePath = packageName.replaceAll("\\.", "/");
        System.out.println(packagePath);
        //com是在类的根路径下的目录
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        String path = url.getPath();    //绝对路径
        System.out.println(path);
        //获取一个绝对路径下的所有文件
        File file = new File(path);
        File[] files = file.listFiles();   //获取所有子文件
        Arrays.stream(files).forEach(f -> {
            try{
                // System.out.println(f.getName());   //文件名
                // System.out.println(f.getName().split("\\.")[0]);    //类名
                String className = packageName + "." + f.getName().split("\\.")[0];
                System.out.println(className);
                //通过反射机制解析注解
                Class<?> aClass = Class.forName(className);
                //判断类上是否有注解
                if(aClass.isAnnotationPresent(Component.class)){
                    //获取注解
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();
                    //有这个注解的都要创建对象
                    Object obj = aClass.newInstance();
                    beanMap.put(id,obj);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        });
        System.out.println(beanMap);
    }
}
