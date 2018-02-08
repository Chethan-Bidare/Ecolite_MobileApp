package TestCases;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CustomerMaster;
import Pages.LoginPage;
import Util.CommFunctions;
import Util.Constants;

public class CustomerMasterTC {
	LoginPage lp = new LoginPage();
	CustomerMaster cm = new CustomerMaster();
	CommFunctions CF= new CommFunctions();
	@Test(priority=1)
	public void CustTest() throws MalformedURLException, InterruptedException{
		
		lp.DeviceCapabilities();
		lp.Login(Constants.Mobile,Constants.Pwd);
		cm.OpenCustomerMaster();
		try{
			Assert.assertEquals("Customer", cm.CustPage);
			System.out.println("Customer Master Page Opened");
		}
		catch(Exception e){
			System.out.println("Customer Master page has not opened");
		}
	}
	@Test(priority=2)
	public void AddNewCustomerTest() throws MalformedURLException, InterruptedException{
		cm.AddNewCustomer();
		try{
		
			Assert.assertEquals(cm.CustAddBtn,"Add New Customer");
			System.out.println("New Customer Added Successfully");
		
		}
		catch(Exception e){
			System.out.println("New Customer Creation Failed");
		}
		CF.CloseApp();
	}

	@Test(priority=3)
	public void SyncCustomerTC() throws MalformedURLException, InterruptedException{
		cm.SyncCustomer();
		try{
			Assert.assertEquals(cm.CustName2,cm.CustName22);
			System.out.println("Customer data sync successfull");
		}
		catch(Exception e){
			System.out.println("Customer data sync Unsuccessfull");
		}
		
	}
}
