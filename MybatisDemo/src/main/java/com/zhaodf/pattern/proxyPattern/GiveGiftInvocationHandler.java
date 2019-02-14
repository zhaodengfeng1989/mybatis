package com.zhaodf.pattern.proxyPattern;

import org.apache.ibatis.reflection.ExceptionUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GiveGiftInvocationHandler implements InvocationHandler {
    //定义目标对象，最后使用反射要调用目标对象中的方法
    //这里使用Object，所有对象都是Object的子类，这里就有了共性
    private Object target;

    //提供构造函数，将目标对象持有
    public GiveGiftInvocationHandler(Object target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //这里我们可以仿照Mybatis中的写法，分开两部分
        //一部分是Object中自有的方法，如toString，HashCode等
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                System.out.println("调用Object类的方法");
                return method.invoke(this, args);
            } catch (Throwable var5) {
                throw ExceptionUtil.unwrapThrowable(var5);
            }
        } else {
            Object result = method.invoke(target,args);
            return result;
        }
    }
}
