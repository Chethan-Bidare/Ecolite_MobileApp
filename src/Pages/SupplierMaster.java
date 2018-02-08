package Pages;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import Util.CommFunctions;
import Util.Constants;

public class SupplierMaster extends LoginPage{

GenerateData gendata = new GenerateData();
CommFunctions cf = new CommFunctions();
LoginPage lp = new LoginPage();
HomePage hp = new HomePage();
MyStorePage Msp = new MyStorePage();

public String SuppPage ;
public String SuppNameCreated ;
public String SuppNameFound ;
public String Supp_AddBtn;

public void OpenSupplierMaster() throws MalformedURLException, InterruptedException{
	hp.mystore();
	Msp.mystore2();
	SuppPage = driver.findElement(By.id("com.c2info.ecolite:id/tvSpHeader")).getText();
}

public void CreateNewSupplier() throws InterruptedException{
	Supp_AddBtn = driver.findElementById(Constants.CustMst_AddNewCustomer).getText();
	driver.findElementById(Constants.CustMst_AddNewCustomer).click();
	SuppNameCreated=gendata.generateRandomString(8);
	System.out.println("Cust Name created :"+SuppNameCreated);
	driver.findElementById(Constants.SuppMst_SuppName).sendKeys(SuppNameCreated);
	driver.findElementById(Constants.SuppMst_DoorNo).sendKeys(gendata.generateRandomNumeric(3));
	driver.findElementById(Constants.SuppMst_Street).sendKeys(gendata.generateRandomString(6));
	driver.hideKeyboard();
	cf.SwipeTop();
	driver.findElementById(Constants.SuppMst_Location).sendKeys(gendata.generateRandomString(8));
	driver.findElementById(Constants.SuppMst_City).sendKeys("Bengaluru");
	driver.findElementById(Constants.SuppMst_Pincode).sendKeys("560027");
	cf.SwipeTop();
	driver.findElementById(Constants.SuppMst_Mobile).sendKeys(gendata.generateRandomNumeric(10));
	driver.findElementById(Constants.SuppMst_EmailID).sendKeys(gendata.generateEmailID(12));
	cf.SwipeTop();
	driver.findElementById(Constants.SuppMst_License1).sendKeys(gendata.generateRandomNumeric(15));
	driver.findElementById(Constants.SuppMst_License2).sendKeys(gendata.generateRandomNumeric(15));
	driver.hideKeyboard();
	driver.findElementById(Constants.SuppMst_GST).sendKeys("29AAAAA1234Q1Q2");
	driver.hideKeyboard();
	driver.findElementById(Constants.SuppMst_Next).click();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElementById(Constants.SuppMst_Save).click();
	Thread.sleep(4000);
}

public void SyncSupplier() throws InterruptedException, MalformedURLException{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.resetApp();
	//Thread.sleep(5000);
	lp.Login(Constants.Mobile,Constants.Pwd);
	OpenSupplierMaster();
	driver.findElementById(Constants.GlobalSearch).click();
	driver.findElementById(Constants.GlobalSearch).sendKeys(SuppNameCreated);
	driver.hideKeyboard();
	SuppNameCreated = SuppNameCreated.toUpperCase();
	Boolean IsPresent = driver.findElements(By.id("com.c2info.ecolite:id/textviewStoreName")).size()>0;
	if(IsPresent==true){
	SuppNameFound = driver.findElementById("com.c2info.ecolite:id/textviewStoreName").getText();
	System.out.println("Cust Name in Search= "+SuppNameFound);
	}
}

}
