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
			logger.debug("System.out.println(����)");
			
		}
		
	    logger.debug("This is debug message");
	    logger.info("This is info message");
	    logger.error("This is error message");
	  

	  }
	
    
	@Before
	    public void setUp() throws  Exception{ 
	       
	     
	
		   //����apk��·��
	        File classpathRoot = new File(System.getProperty("user.dir"));
	        File appDir = new File(classpathRoot, "apps");
	        File app = new File(appDir, "2016-10-06.apk");
	        
	       //�����Զ�������
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	        capabilities.setCapability("platformName", "Android");
	        //���ð�׿�汾
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
	        	
	       System.out.println("app �Ѿ�����������");
	       
	       Thread.sleep(8000);
	       System.out.print("�ȴ����");
	       //findElementByName��ͨ���ؼ��ϵ�����ʶ��
        
         
           
	       //driver.findElementById("com.glks.chat:id/account_edit").sendKeys("18204092898");	      
	       //driver.findElementById("com.glks.chat:id/password_edit").sendKeys("111111");	      
	       //driver.findElementById("com.glks.chat:id/login_button").click();
	       
	       //test = driver.findElement(By.className("android.widget.TextView"));
	       //WebElement number=driver.findElementByXPath("//android.widget.LinearLayout/android.widget.TextView[0]");
	    		
	    		   //classname[contains(@Text,"�ֻ���")];
	      // WebElement element=driver.findElement(By.xpath("//android.widget.TextView[contains(@Text,�ֻ���)]"));
	       
	    		   //driver.findElement(By.xpath("//android.widget.TextView[contains(@Text,�ֻ���)]"));
	    	//	   System.out.print("У��ҳ���ֻ������ֳ���");
	     //driver.findElementByXPath("//android.widget.LinearLayout/android.widget.EditText[1]").sendKeys("18204092898");

	       WebElement number=driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.EditText[1]"));
	       WebElement password=driver.findElement(By.id("com.glks.chat:id/password_edit"));
	       WebElement button1=driver.findElement(By.id("com.glks.chat:id/login_button"));
	       number.sendKeys("18204092898");
	       System.out.println("�û������룡��");
	       
	       password.sendKeys("1111111");
	       System.out.println("�������룡��");
	       button1.click();
	       System.out.println("�������");
	       
	       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	       Assert.assertEquals(driver.findElementById("com.glks.chat:id/login_button").getText(),"ֱ�ӵ�¼"); 
	       button1.click();
	       System.out.println("�������");
	       
	       System.out.println(driver.findElementById("//android.widget.Button").getText());
	       
	       
	  
	     
	      
	       
	 } 
	         
		@After
	       public void tearDown() throws Exception{ 
	    	   driver.quit();
	    	   }       	    
	}
