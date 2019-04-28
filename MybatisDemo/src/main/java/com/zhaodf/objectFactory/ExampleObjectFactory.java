package com.zhaodf.objectFactory;

import com.zhaodf.model.MalltUserModel;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

public class ExampleObjectFactory extends DefaultObjectFactory {
    //这里我们重新写一下带参数的构造方法，当传入参数的时候，我们实体类中的init方法验证
    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T t = super.create(type, constructorArgTypes, constructorArgs);
        if(MalltUserModel.class.isAssignableFrom(type)){
            MalltUserModel model = (MalltUserModel) t;
            ((MalltUserModel) t).init();
        }
        return t;
    }

    //这里处理的是objectFactory标签中设置的property
    @Override
    public void setProperties(Properties properties) {
        System.out.println("在配置文件中设置的objectFactory的property：["+properties.toString()+"]");
        super.setProperties(properties);
    }
}
