package com.zjh.spring.beans.factorybean;

import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: zjh
 * @Date: 2019/4/30 10:21
 * @Version 1.0
 */
//自定义的FactoryBean 需要实现FactoryBean 接口
public class CarFactoryBean implements FactoryBean{

    @Setter
    private String brand;


    //返回bean的对象
    @Override
    public Object getObject() throws Exception {
        return new Car(brand,500000);
    }

    /**
     * 返回bean的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

}
