package Pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

	public static AndroidDriver<WebElement> driver ;
	public static String bid ;
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public void DeviceCapabilities() throws MalformedURLException{
		
		capabilities.setCapability(CapabilityType.BROWSER_NAME,"ANDROID");
		capabilities.setCapability(CapabilityType.VERSION,"5.1");
		capabilities.setCapability("deviceName","ZX1D64CPT2");
		capabilities.setCapability("platformName","ANDROID");
		capabilities.setCapability("appPackage","com.c2info.ecolite");
		capabilities.setCapability("appActivity","com.c2info.ecolite.ui.activity.SplashScreenActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		//return new LoginPage();
		
		
	}

	public void Login(String Mobile,String Pwd) throws MalformedURLException, InterruptedException{
	
		//DeviceCapabilities();
	    Thread.sleep(5000);
	    Boolean IsPresent = driver.findElements(By.id("com.c2info.ecolite:id/textview_not_you")).size()>0;
	   if(IsPresent ==true){
		WebElement NotYou = driver.findElement(By.id("com.c2info.ecolite:id/textview_not_you"));
		driver.tap(1, NotYou, 1);
	   }
		driver.findElement(By.id("com.c2info.ecolite:id/edit_user_id")).sendKeys(Mobile);
		driver.findElement(By.id("com.c2info.ecolite:id/edit_user_pwd")).sendKeys(Pwd);
		try{
			driver.hideKeyboard();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		driver.findElement(By.id("com.c2info.ecolite:id/button_sign_in")).click();
		driver.manage().timeouts().implicitlyWait(180,TimeUnit.SECONDS);
		bid =driver.findElement(By.id("com.c2info.ecolite:id/main_toolbar_title")).getText();
		System.out.println(bid);
	    
	   
	}


}
