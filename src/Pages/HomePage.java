package Pages;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Util.Constants;

public class HomePage extends LoginPage{

public void mystore() throws MalformedURLException, InterruptedException{
	
	    driver.hideKeyboard();
		WebElement Mystore = driver.findElement(By.xpath(Constants.MystoreTab));
		driver.tap(1, Mystore,1);
		//return new MyStorePage();
		
	}
	
	public void purchase(){
		WebElement PurchaseTab =driver.findElement(By.xpath(Constants.PurchaseTab));
		driver.tap(1, PurchaseTab, 1);
	}
	
	public void Sales(){
		WebElement SalesTab = driver.findElement(By.xpath(Constants.SaleTab));
		driver.tap(1, SalesTab, 1);
	}
	
	
}
