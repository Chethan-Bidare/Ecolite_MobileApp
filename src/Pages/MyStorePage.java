package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Util.Constants;

public class MyStorePage extends LoginPage{

public CustomerMaster mystores(){
		
		WebElement Cust = driver.findElement(By.xpath(Constants.Customer));
		driver.tap(1, Cust, 1);
		return new CustomerMaster();
		
	}
	
public ItemMaster mystore1(){
		
		driver.findElement(By.xpath(Constants.MystoreTab)).click();
		
		
		return new ItemMaster();
		
	}

public SupplierMaster mystore2(){
	
	WebElement Supp = driver.findElement(By.xpath(Constants.Supplier));
	driver.tap(1, Supp, 1);
	return new SupplierMaster();
	
}
}
