package TestCases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SalesInvoice;
import Util.CommFunctions;
import Util.Constants;

public class SalesInvoiceTC {
LoginPage LP= new LoginPage();
CommFunctions CF= new CommFunctions();
SalesInvoice SI = new SalesInvoice();


/*@Test(priority=1)
public void CreateNewBatch() throws MalformedURLException, InterruptedException{
	LP.DeviceCapabilities();
	LP.Login(Constants.Mobile,Constants.Pwd);
	SI.AddNewBatch();
	try{
		Assert.assertEquals(SI.batchnumEntered, SI.CheckBatch);
		System.out.println("New Batch created Successfully");
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

@Test(priority=2)
public void CheckBatchCreatedIsSelected(){	
	SI.GetDetailsOfBatchAdded();
	try{
		Assert.assertEquals( SI.RetrievedBatchNum, SI.batchnumEntered);
		System.out.println("Newly Created batch checkbox is selected");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	CF.CloseApp();
}


@Test(priority=3)
public void SelectCustomerTC() throws MalformedURLException, InterruptedException{
	LP.DeviceCapabilities();
	LP.Login(Constants.Mobile,Constants.Pwd);
	SI.SelectCustomer();
	
	try{
		Assert.assertEquals(SI.SearchFieldCustName, SI.SalesHeaderCustName);
		System.out.println("Customer selected Successfully");
	}
	catch(Exception e){
		e.printStackTrace();
	}
}


@Test(priority=4)
public void AddItems(){
	SI.AddItems();
	try{
	Assert.assertEquals(SI.sumOfItemwiseMRP, SI.ItemCartTotal);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	CF.CloseApp();
}

@Test(priority=5)
public void VerifyStockAfterSale() throws MalformedURLException, InterruptedException{
	LP.DeviceCapabilities();
	LP.Login(Constants.Mobile,Constants.Pwd);
	SI.StockCheckAfterSale();
	try{
		Assert.assertEquals(SI.ActualStockAfterSale, SI.ExpectedStockAfterSale);
		System.out.println("Stock reduced After Sale");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		CF.CloseApp();
}
*/
@Test(priority=6)
public void VerifySalesByDisc() throws MalformedURLException, InterruptedException{
	LP.DeviceCapabilities();
	LP.Login(Constants.Mobile,Constants.Pwd);
	SI.SalesInvByDisc();
	try{
		Assert.assertEquals(SI.CalculatedMRPAfterDisc, SI.ItemCartTotal);
		System.out.println("Calculated MRP for all items after discount is matching with the Cart total Amount");
	}
	catch(Exception e){
		System.out.println("Calculated MRP for all items after discount is NOT matching with the Cart total Amount");
	}
	try{
		Assert.assertEquals(SI.CalculatedTotalDiscount, SI.TotalDiscAmtinCheckOutPage);
		System.out.println("Calculated Discount is matching with CheckOut Page Discount Value");
	}
	catch(Exception e){
		System.out.println("Calculated Discount is NOT matching with CheckOut Page Discount Value");
	}
	try{
		Assert.assertEquals(SI.CalculatedTotalDiscount,SI.DiscAmtInSuccessPage);
		System.out.println("Disc Amt in CheckOut Page is matching with Disc Amt in Success Page");
	}
	catch(Exception e){
		System.out.println("Calculated Discount is NOT matching with Disc Amt in Success Page");
	}
	
	CF.CloseApp();
}
}
