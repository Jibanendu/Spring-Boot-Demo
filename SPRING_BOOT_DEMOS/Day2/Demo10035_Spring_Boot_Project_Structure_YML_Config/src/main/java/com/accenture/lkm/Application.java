package com.accenture.lkm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.accenture.lkm.bussiness.bean.EmployeeListReader;

@SpringBootApplication
public class Application {

	static private Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext cfg=SpringApplication.run(Application.class, args);
        EmployeeListReader read=  (EmployeeListReader)cfg.getBean("employeeListReader");
        logger.info("****************************************************************");
        logger.info("Data read is:"+read);
        logger.info("****************************************************************");
    }
    
}

