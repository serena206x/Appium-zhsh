package com.log4j;

import org.apache.log4j.Logger;

import com.test.demo.LoginTest;

public class Log4j {
   private static Logger logger=Logger.getLogger(LoginTest.class);


public static void main(String[] args){
 
	if(logger.isDebugEnabled()){
		logger.debug("System.out.println(¡°¡±)");
		
	}
	
    logger.debug("This is debug message");
    logger.info("This is info message");
    logger.error("This is error message");
  

  }
}
