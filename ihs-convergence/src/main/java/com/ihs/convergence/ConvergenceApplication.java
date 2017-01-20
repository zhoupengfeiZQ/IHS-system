package com.ihs.convergence;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 
 * 该类是生产环境下的启动类，开发环境下使用。
 * 
 * @author pengfei.Zhou
 * @date 2017年1月20日 
 * @email pengfei.zhou@hand-china.com
 *
 */
@ComponentScan(value = "com.ihs.convergence")
@MapperScan(value = "com.ihs.convergence.dao")
@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class,
		JpaRepositoriesAutoConfiguration.class,MultipartAutoConfiguration.class })
public class ConvergenceApplication 
{
	private final static Logger logger = LoggerFactory.getLogger(ConvergenceApplication.class);
    public static void main( String[] args )
    {
    	logger.info("logback {}", "INFO ( TRACE < DEBUG < INFO < WARN < ERROR )");
		SpringApplication.run(new Object[] { ConvergenceApplication.class }, args);
        System.out.println( "ihs started..." );
    }
}