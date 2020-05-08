package com.host.annotation.t1;

import java.lang.reflect.Field;

/**
 * created by xiaoyao01  on 2020/5/8.
 **/
public class TestHandle {
    public static void valid(UsingAnnoation root) {
        //解析注解校验
        Class<? extends UsingAnnoation> aClass = root.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();//反射获得属性
        for(Field field : declaredFields){
            Test testAnno = field.getAnnotation(Test.class);
            if (testAnno != null){
                field.setAccessible(true);
                if(field.getType().getTypeName().equals("java.lang.String")){
                    //判断最大最小长度给出信息
                    try {
                        Object o = field.get(root);
                        if (o instanceof String){
                            String s = (String) o;
                            if( s.length()>testAnno.max() ||  s.length()<testAnno.min()){
                                System.out.println(testAnno.description());
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println(" not string type");
                };
            }
        }

    }

}
