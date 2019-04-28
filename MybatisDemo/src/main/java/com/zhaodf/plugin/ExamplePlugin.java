package com.zhaodf.plugin;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

@Intercepts({@Signature(
        type= Executor.class,
        method = "update",
        args = {MappedStatement.class,Object.class})})
public class ExamplePlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
//        Object[] queryArgs = invocation.getArgs();
//        MappedStatement mappedStatement = (MappedStatement) queryArgs[0];
//        Object parameter = queryArgs[1];
//        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
//        //获取到SQL ，可以进行调整
//        String sql = boundSql.getSql();
//        String name = invocation.getMethod().getName();
//        System.out.println("拦截的方法名是：" + name+"，对应的sql语句是："+sql+"对应的参数为："+parameter.toString());
        return invocation.proceed();
    }

    public Object plugin(Object o) {
        return  Plugin.wrap(o, this);
    }

    public void setProperties(Properties properties) {
        System.out.println("在配置文件中设置的plugin的property：["+properties.toString()+"]");
    }
}
