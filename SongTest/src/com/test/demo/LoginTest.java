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
	        //����apk��·��
	        File classpathRoot = new File(System.getProperty("user.dir"));
	        File appDir = new File(classpathRoot, "apps");
	        File app = new File(appDir, "����-2016-10-06.apk");	         
	         //�����Զ�����ز���
	         DesiredCapabilities capabilities = new DesiredCapabilities();
	         capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	         capabilities.setCapability("platformName", "Android");
	         capabilities.setCapability("deviceName", "emulator-5554");	         
	         //���ð�׿ϵͳ�汾
	         capabilities.setCapability("platformVersion", "4.3");
	         //����apk·��
	         capabilities.setCapability("app", app.getAbsolutePath()); 	         
	         //����app����������������
	         capabilities.setCapability("appPackage", "com.glks.chat");
	         capabilities.setCapability("appActivity", "ui.activity.SplashActivity");	         
	         //��ʼ��
	         driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);       
	     }	  
	     @Test
	     public void Login() throws InterruptedException{
	    	   System.out.println("Info��app �Ѿ�����������");		       
		       Thread.sleep(10000);
		       System.out.println("Info���ȴ����");
	           /*�����������û���������������Լ���¼��ť*/
		       WebElement el = driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.EditText[1]"));
	           WebElement password=driver.findElement(By.id("com.glks.chat:id/password_edit"));
		       WebElement button1=driver.findElement(By.id("com.glks.chat:id/login_button"));
		       WebElement Image=driver.findElement(By.className("android.widget.ImageView"));
		       WebElement v1=driver.findElementByXPath("//android.widget.RelativeLayout/android.widget.TextView[1]");
		       WebElement v2=driver.findElementByXPath("//android.widget.RelativeLayout/android.widget.TextView[2]");
		       
		       //��֤ͼ����ʾ
		       Assert.assertEquals(Image.isDisplayed(), true);
		       System.out.println("Info��ҳ������Logo���سɹ�");
		       Assert.assertEquals(el.isDisplayed(), true);
		       System.out.println("Info���ֻ����������سɹ�");
		       Assert.assertEquals(password.isDisplayed(), true);
		       System.out.println("Info�������������سɹ�");
		       Assert.assertEquals(v1.isDisplayed(), true);
		       System.out.println("Info�����û�ע����ڼ��سɹ�");
		       Assert.assertEquals(v2.isDisplayed(), true);
		       System.out.println("Info����֤���¼��ڼ��سɹ�");
		       
		       /*********����λ�����¼��ť������֤************/
		       el.sendKeys("18204092898");
		       System.out.println("Info��������λ����ȷ���ֻ���");
		       password.sendKeys("1111");
		       System.out.println("Info�������˲���6λ������");
		       Assert.assertEquals(button1.getAttribute("clickable"), "false"); 
		       System.out.println("Info����¼��ťδ������޷���¼");
		       el.sendKeys("18204092");
		       System.out.println("Info������������11λ���ֻ���");
		       password.sendKeys("1111111");
		       System.out.println("Info�������˴���6λ������");
		       Assert.assertEquals(button1.getAttribute("clickable"), "true");
		       System.out.println("Info����¼��ť����");
		       button1.click();
		       Alert alert;
		       alert = driver.switchTo().alert();
		       System.out.println(alert);
		       driver.getWindowHandle();
		       //alert.dismiss();
		       Assert.assertEquals(driver.findElementById("com.glks.chat:id/toolbar").isDisplayed(), false);
		     
		       // WebElement tip=driver.findElement(By.className("android.widget.RelativeLayout"));
		      // Assert.assertEquals(tip.getText(),"�˺������¼���ֻ����������������");
		       
		       //System.out.println(driver.currentActivity());
		       // System.out.println("Info��������ʾ����..........");
		       /****���������û�������**/
		       //�����������
		       el.sendKeys("18204092898");
		       System.out.println("Info����ȷ�û������룡��");
		       password.sendKeys("1111112");
		       System.out.println("Info�������������룡��");
		       button1.click();
		       Assert.assertEquals(driver.findElementById("com.glks.chat:id/login_button").getText(),"ֱ�ӵ�¼");
		       System.out.println(driver.findElementById("//com.glks.chat:id/login_button").getText());
		       driver.getContext();
		       System.out.println("Info����¼���ɹ���ʾ����");
		       //�����ֻ��Ŵ���
		       //����Ƿ�У������ֻ���
		       //����Ƿ�����
		       
		       /*****������ȷ���ֻ��ź�����*******/
		       //��ȷ�˺�����
	           el.sendKeys("18204092898");
		       System.out.println("Info���û������룡��");
		       password.sendKeys("111111");
		       System.out.println("Info���������룡��");
		       Assert.assertEquals(button1.isEnabled(), true);  
		       button1.click();
		       System.out.println("Info���������");
	    
	           /**********��֤��¼�ɹ�************/
		       //��֤��Ϣ���ֳ���
		       Assert.assertEquals(driver.findElementByClassName("android.widget.TextView").getText(),"��Ϣ");
	           //��֤��������������
		       Assert.assertEquals(driver.findElementById("com.glks.chat:id/toolbar").isDisplayed(), true);
	     }    
	     
	    @After
	     public void tearDown() throws Exception {
	         driver.quit();
	     }
}

