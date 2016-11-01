package com.test.demo;

import io.appium.java_client.AppiumDriver;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities; 
import org.apache.log4j.Logger;
import java.awt.Button;
import java.io.File;  
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class SongTest {
 	
	private AppiumDriver driver;
	private static Logger logger=Logger.getLogger(SongTest.class);
 
	//static AndroidDriver<?> driver=null;
	//private WebElement test;
	
	//public AndroidDriver<?> wd =null;
	//AndroidDriverImpl<T> adi = new AndroidDriverImpl<T>();
	
	public static void main(String[] args){
		 
		if(logger.isDebugEnabled()){
			logger.debug("System.out.println(“”)");
			
		}
		
	    logger.debug("This is debug message");
	    logger.info("This is info message");
	    logger.error("This is error message");
	  

	  }
	
    
	@Before
	    public void setUp() throws  Exception{ 
	       
	     
	
		   //设置apk的路径
	        File classpathRoot = new File(System.getProperty("user.dir"));
	        File appDir = new File(classpathRoot, "apps");
	        File app = new File(appDir, "2016-10-06.apk");
	        
	       //设置自动化参数
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	        capabilities.setCapability("platformName", "Android");
	        //设置安卓版本
	        capabilities.setCapability("deviceName","emulator-5554");
	        capabilities.setCapability("platformVersion", "4.3");
	        capabilities.setCapability("app", app.getAbsolutePath());
	        capabilities.setCapability("appPackage", "com.glks.chat");
	        capabilities.setCapability("appActivity", "ui.activity.SplashActivity");
	       // driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    	//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	 }
	        
	        @Test
	       public void Test() throws Exception{
	        	
	       System.out.println("app 已经运行啦！！");
	       
	       Thread.sleep(8000);
	       System.out.print("等待完成");
	       //findElementByName是通过控件上的文字识别
        
         
           
	       //driver.findElementById("com.glks.chat:id/account_edit").sendKeys("18204092898");	      
	       //driver.findElementById("com.glks.chat:id/password_edit").sendKeys("111111");	      
	       //driver.findElementById("com.glks.chat:id/login_button").click();
	       
	       //test = driver.findElement(By.className("android.widget.TextView"));
	       //WebElement number=driver.findElementByXPath("//android.widget.LinearLayout/android.widget.TextView[0]");
	    		
	    		   //classname[contains(@Text,"手机号")];
	      // WebElement element=driver.findElement(By.xpath("//android.widget.TextView[contains(@Text,手机号)]"));
	       
	    		   //driver.findElement(By.xpath("//android.widget.TextView[contains(@Text,手机号)]"));
	    	//	   System.out.print("校验页面手机号文字出现");
	     //driver.findElementByXPath("//android.widget.LinearLayout/android.widget.EditText[1]").sendKeys("18204092898");

	       WebElement number=driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.EditText[1]"));
	       WebElement password=driver.findElement(By.id("com.glks.chat:id/password_edit"));
	       WebElement button1=driver.findElement(By.id("com.glks.chat:id/login_button"));
	       number.sendKeys("18204092898");
	       System.out.println("用户名输入！！");
	       
	       password.sendKeys("1111111");
	       System.out.println("密码输入！！");
	       button1.click();
	       System.out.println("点击！！");
	       
	       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	       Assert.assertEquals(driver.findElementById("com.glks.chat:id/login_button").getText(),"直接登录"); 
	       button1.click();
	       System.out.println("点击！！");
	       
	       System.out.println(driver.findElementById("//android.widget.Button").getText());
	       
	       
	  
	     
	      
	       
	 } 
	         
		@After
	       public void tearDown() throws Exception{ 
	    	   driver.quit();
	    	   }       	    
	}
