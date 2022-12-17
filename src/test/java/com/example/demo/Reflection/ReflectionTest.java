package com.example.demo.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型作用于编译期,会在编译之前对程序进行检查
 * 编译期过后,泛型约束失效
 * 反射作用于运行期
 * 演示通过反射越过泛型的检查
 */
public class ReflectionTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1.先声明一个List集合,元素泛型约束为String类型
        List<String> strList=new ArrayList<>();
        //2.向集合中添加String型的元素
        strList.add("aa");
        strList.add("bb");
        //注:在编译期之前,向集合中添加非泛型元素,程序会在编译期就报错
        //strList.add(123);
        //这时,我们通过反射来越过泛型检查
        Class strListClass = strList.getClass();//先获取Class对象
        //获取add方法,为了保障程序清晰,在main方法上抛出异常
        Method method = strListClass.getMethod("add", Object.class);
        //通过反射调用add方法,添加一个int型数据
        method.invoke(strList,123);
        System.out.println("strList="+strList);
    }
}