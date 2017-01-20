package com.ihs.convergence.conf;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * 
 * MyBatisMapper扫描配置
 * 
 * @author pengfei.zhou
 * @date   2016-01-20
 *
 */
@Configuration
//将mapperScannerConfigure推迟到MyBatisConfig加载之后
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.ihs.convergence.dao.*");

        Properties properties = new Properties();
        properties.setProperty("mappers",Mapper.class.getName());
        properties.setProperty("notEmpty","false");
        properties.setProperty("IDENTITY","MYSQL");

        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}

