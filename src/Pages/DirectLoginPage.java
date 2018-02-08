package Pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

public class DirectLoginPage extends LoginPage {

	//WebDriver Driver;
	public static String bid2 ;
	public HomePage directLogin(String Pwd) throws InterruptedException, MalformedURLException{
		
		//LoginPage lp = new LoginPage();
		//lp.DeviceCapabilities();
		Thread.sleep(10000);
		//driver.findElement(By.className("android.widget.EditText")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[234,652][486,743]' or @index='3']")).sendKeys(Pwd);
		Thread.sleep(30000);
		bid2 =driver.findElement(By.id("com.c2info.ecolite:id/main_toolbar_title")).getText();
		System.out.println(bid2);
		
		return new HomePage();
		
	}

}
