package com.test.demo;

import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities; 

import com.thoughtworks.selenium.Wait;

import java.io.File;  
import java.net.URL;  
import java.util.List;

public class LoginTest {
	    private AppiumDriver driver; 	    
	     @Before
	     public void setUp() throws Exception {
	        //设置apk的路径
	        File classpathRoot = new File(System.getProperty("user.dir"));
	        File appDir = new File(classpathRoot, "apps");
	        File app = new File(appDir, "内网-2016-10-06.apk");	         
	         //设置自动化相关参数
	         DesiredCapabilities capabilities = new DesiredCapabilities();
	         capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	         capabilities.setCapability("platformName", "Android");
	         capabilities.setCapability("deviceName", "emulator-5554");	         
	         //设置安卓系统版本
	         capabilities.setCapability("platformVersion", "4.3");
	         //设置apk路径
	         capabilities.setCapability("app", app.getAbsolutePath()); 	         
	         //设置app的主包名和主类名
	         capabilities.setCapability("appPackage", "com.glks.chat");
	         capabilities.setCapability("appActivity", "ui.activity.SplashActivity");	         
	         //初始化
	         driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);       
	     }	  
	     @Test
	     public void Login() throws InterruptedException{
	    	   System.out.println("Info：app 已经运行啦！！");		       
		       Thread.sleep(10000);
		       System.out.println("Info：等待完成");
	           /*声明变量，用户名，密码输入框以及登录按钮*/
		       WebElement el = driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.EditText[1]"));
	           WebElement password=driver.findElement(By.id("com.glks.chat:id/password_edit"));
		       WebElement button1=driver.findElement(By.id("com.glks.chat:id/login_button"));
		       WebElement Image=driver.findElement(By.className("android.widget.ImageView"));
		       WebElement v1=driver.findElementByXPath("//android.widget.RelativeLayout/android.widget.TextView[1]");
		       WebElement v2=driver.findElementByXPath("//android.widget.RelativeLayout/android.widget.TextView[2]");
		       
		       //验证图标显示
		       Assert.assertEquals(Image.isDisplayed(), true);
		       System.out.println("Info：页面中央Logo加载成功");
		       Assert.assertEquals(el.isDisplayed(), true);
		       System.out.println("Info：手机号输入框加载成功");
		       Assert.assertEquals(password.isDisplayed(), true);
		       System.out.println("Info：密码输入框加载成功");
		       Assert.assertEquals(v1.isDisplayed(), true);
		       System.out.println("Info：新用户注册入口加载成功");
		       Assert.assertEquals(v2.isDisplayed(), true);
		       System.out.println("Info：验证码登录入口加载成功");
		       
		       /*********输入位数与登录按钮激活验证************/
		       el.sendKeys("18204092898");
		       System.out.println("Info：输入了位数正确的手机号");
		       password.sendKeys("1111");
		       System.out.println("Info：输入了不足6位的密码");
		       Assert.assertEquals(button1.getAttribute("clickable"), "false"); 
		       System.out.println("Info：登录按钮未被激活，无法登录");
		       el.sendKeys("18204092");
		       System.out.println("Info：输入了少于11位的手机号");
		       password.sendKeys("1111111");
		       System.out.println("Info：输入了大于6位的密码");
		       Assert.assertEquals(button1.getAttribute("clickable"), "true");
		       System.out.println("Info：登录按钮激活");
		       button1.click();
		       Alert alert;
		       alert = driver.switchTo().alert();
		       System.out.println(alert);
		       driver.getWindowHandle();
		       //alert.dismiss();
		       Assert.assertEquals(driver.findElementById("com.glks.chat:id/toolbar").isDisplayed(), false);
		     
		       // WebElement tip=driver.findElement(By.className("android.widget.RelativeLayout"));
		      // Assert.assertEquals(tip.getText(),"账号密码登录，手机或者密码输入错误！");
		       
		       //System.out.println(driver.currentActivity());
		       // System.out.println("Info：错误提示出现..........");
		       /****输入错误的用户名密码**/
		       //输入密码错误
		       el.sendKeys("18204092898");
		       System.out.println("Info：正确用户名输入！！");
		       password.sendKeys("1111112");
		       System.out.println("Info：错误密码输入！！");
		       button1.click();
		       Assert.assertEquals(driver.findElementById("com.glks.chat:id/login_button").getText(),"直接登录");
		       System.out.println(driver.findElementById("//com.glks.chat:id/login_button").getText());
		       driver.getContext();
		       System.out.println("Info：登录不成功提示出现");
		       //输入手机号错误
		       //输入非法校验规则手机号
		       //输入非法密码
		       
		       /*****输入正确的手机号和密码*******/
		       //正确账号密码
	           el.sendKeys("18204092898");
		       System.out.println("Info：用户名输入！！");
		       password.sendKeys("111111");
		       System.out.println("Info：密码输入！！");
		       Assert.assertEquals(button1.isEnabled(), true);  
		       button1.click();
		       System.out.println("Info：点击！！");
	    
	           /**********验证登录成功************/
		       //验证消息文字出现
		       Assert.assertEquals(driver.findElementByClassName("android.widget.TextView").getText(),"消息");
	           //验证顶部工具栏出现
		       Assert.assertEquals(driver.findElementById("com.glks.chat:id/toolbar").isDisplayed(), true);
	     }    
	     
	    @After
	     public void tearDown() throws Exception {
	         driver.quit();
	     }
}

