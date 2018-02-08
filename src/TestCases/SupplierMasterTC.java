package TestCases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SupplierMaster;
import Util.CommFunctions;
import Util.Constants;


public class SupplierMasterTC {
	LoginPage lp = new LoginPage();
	SupplierMaster Sp = new SupplierMaster(); 
	CommFunctions CF= new CommFunctions();
	
	@Test(priority=1)
	public void OpenSupplierMasterTC() throws MalformedURLException, InterruptedException{
	lp.DeviceCapabilities();
	lp.Login(Constants.Mobile, Constants.Pwd);
	Sp.OpenSupplierMaster();
	try{
		Assert.assertEquals(Sp.SuppPage,"Supplier");
		System.out.println("Supplier Page Opened Successfully");
	}
	catch(Exception e){
		System.out.println("Supplier Page is not Opened");
	}	
	}

	@Test(priority=2)
	public void CreateSupplierTC() throws InterruptedException{
		Sp.CreateNewSupplier();
		try{
			Assert.assertEquals(Sp.Supp_AddBtn, "Add New Supplier");
			System.out.println("Supplier Master created Successfully");
		}
		catch(Exception e){
			System.out.println("Supplier Master is not created ");
		}
	}
	
	@Test(priority=3)
	public void SyncSupplierTC() throws MalformedURLException, InterruptedException{
		Sp.SyncSupplier();
		try{
			Assert.assertEquals(Sp.SuppNameCreated,Sp.SuppNameFound);
			System.out.println("Supplier Sync Successfull");
		}
		catch(Exception e){
			System.out.println("Supplier Sync Unsuccessfull");
		}
		CF.CloseApp();
	}
}
