package TestCases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Util.CommFunctions;
import Util.Constants;

public class LoginTest {
	LoginPage lp = new LoginPage();
	CommFunctions CF= new CommFunctions();
	
	 @Test(priority=2)
	  public void loginTC() throws MalformedURLException, InterruptedException {
		  
		  lp.DeviceCapabilities();
		  lp.Login(Constants.Mobile,Constants.Pwd);
		  try{
			  String bid1 = LoginPage.bid;
			  Assert.assertEquals("Home", bid1);
			  System.out.println("TC Login Passed");
		  }
		  catch(Exception e){
			  System.out.println("TC Login Failed");
		  }
		  CF.CloseApp();
		  //driver.quit();
	 }
	 
	 /*@Test(priority=1000)
	 public void DirectLoginTC() throws MalformedURLException, InterruptedException{
		 DirectLoginPage dp = new DirectLoginPage();
		 dp.directLogin(Constants.Pwd);
		 try{
			  String bid1 = DirectLoginPage.bid2;
			  Assert.assertEquals("Home", bid1);
			  System.out.println("TC Direct Login Passed");
		  }
		  catch(Exception e){
			  System.out.println("TC Direct Login Failed");
		  }
		 driver.quit();
	 }*/
		 
}


