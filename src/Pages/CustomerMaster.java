package Pages;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import Util.CommFunctions;
import Util.Constants;

public class CustomerMaster extends LoginPage {

public  String CustPage;
public String CustAddBtn;

GenerateData gendata = new GenerateData();
CommFunctions cf = new CommFunctions();
LoginPage lp = new LoginPage();
HomePage hp = new HomePage();
MyStorePage Msp = new MyStorePage();

public String CustName22;
public String CustName2;

	public void OpenCustomerMaster() throws MalformedURLException, InterruptedException{
		hp.mystore();
		Msp.mystores();
		CustPage = driver.findElement(By.id("com.c2info.ecolite:id/tvSpHeader")).getText();
	}
	
	public void AddNewCustomer() throws MalformedURLException, InterruptedException{
		CustAddBtn=driver.findElementById(Constants.CustMst_AddNewCustomer).getText();
		driver.findElementById(Constants.CustMst_AddNewCustomer).click();
		CustName22=gendata.generateRandomString(8);
		System.out.println("Cust Name created :"+CustName22);
		driver.findElementById(Constants.CustMst_CustomerName).sendKeys(CustName22);
		driver.findElementById(Constants.CustMst_DoorNo).sendKeys(gendata.generateRandomNumeric(3));
		driver.findElementById(Constants.CustMst_Street).sendKeys(gendata.generateRandomString(6));
		cf.SwipeTop();
		driver.findElementById(Constants.CustMst_Location).sendKeys(gendata.generateRandomString(8));
		driver.findElementById(Constants.CustMst_City).sendKeys("Bengaluru");
		driver.findElementById(Constants.CustMst_Pincode).sendKeys("560027");
		cf.SwipeTop();
		driver.findElementById(Constants.CustMst_Mobile).sendKeys(gendata.generateRandomNumeric(10));
		cf.SwipeTop();
		driver.findElementById(Constants.CustMst_CreditDays).sendKeys(gendata.generateRandomNumeric(1));
		driver.findElementById(Constants.CustMst_Discount).sendKeys(gendata.generateRandomNumeric(1));
		driver.hideKeyboard();
		driver.findElementById(Constants.CustMst_GST).sendKeys("29AAAAA1234Q1Q2");
		driver.hideKeyboard();
		driver.findElementById(Constants.CustMst_Save).click();
			}

	public void SyncCustomer() throws InterruptedException, MalformedURLException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.resetApp();
		
		Thread.sleep(5000);
		lp.Login(Constants.Mobile,Constants.Pwd);
		OpenCustomerMaster();
		
		driver.findElementById(Constants.GlobalSearch).click();
		driver.findElementById(Constants.GlobalSearch).sendKeys(CustName22);
		driver.hideKeyboard();
		CustName2 = driver.findElementById("com.c2info.ecolite:id/textviewCustomerName").getText();
		System.out.println("Cust Name in Search= "+CustName2);

	}
}
