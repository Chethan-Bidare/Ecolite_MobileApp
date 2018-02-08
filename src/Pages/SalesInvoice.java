package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Util.CommFunctions;
import Util.Constants;


public class SalesInvoice extends LoginPage {

	public String SearchFieldCustName;
	public String SalesHeaderCustName;
	public float ItemCartTotal;
	public float sumOfItemwiseMRP;
	public float CalculatedMRPAfterDisc;
	public float CalculatedTotalDiscount;
	public String batchnumEntered;
	public String RetrievedBatchNum;
	public String CheckBatch;
	public int ExpectedStockAfterSale;
	public int ActualStockAfterSale;
	public float TotalDiscAmtinCheckOutPage;
	public float DiscAmtInSuccessPage;
	
	
	GenerateData genData = new GenerateData();
	CommFunctions CF = new CommFunctions();
	
	List<String> Itemname = new ArrayList<String>();
	
	public void SelectCustomer() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElementById(Constants.SearchField).sendKeys("c");
		String b=driver.findElementById(Constants.SearchField).getText();
		if(b.equalsIgnoreCase("cc")){
			driver.findElementById(Constants.SearchField).clear();
			driver.findElementById(Constants.SearchField).sendKeys("c");
		}
		Thread.sleep(3000);
		driver.findElementById(Constants.NewSaleRadiobtn).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SearchFieldCustName =driver.findElementById(Constants.SearchField).getText();
		System.out.println(SearchFieldCustName);
		//driver.findElementById(Constants.SearchField).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById(Constants.StartButton).click();
		SalesHeaderCustName = driver.findElementById(Constants.HeaderCustName).getText();
		System.out.println(SalesHeaderCustName);
	}
	
	public void AddItems(){
		CF.hidekeyboard();
		driver.findElementById(Constants.StartButton).click();	
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		List<WebElement> ItemNames = driver.findElements(By.id(Constants.itemlist));
		
		List<String> ItemMrp = new ArrayList<String>();
		sumOfItemwiseMRP= 0;
		//List of web elements for item names
		for(WebElement we :ItemNames){
			Itemname.add(we.getText());
			System.out.println(Itemname);
		}
		for(int i =0;i<Itemname.size()-4;i++){
			String a = Itemname.get(i);
			driver.findElementByName(a).click();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.findElementById(Constants.AddItemQty).clear();
			String Qty =genData.generateRandomNumeric(1); 
			driver.findElementById(Constants.AddItemQty).sendKeys(Qty);
			CF.hidekeyboard();
			String Itemrate =driver.findElementById(Constants.ItemBatchMRP).getText();
			Itemrate = Itemrate.replaceFirst("\\W","");
			Itemrate = Itemrate.replaceAll(",", "");
			ItemMrp.add(Itemrate) ;
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.findElementById(Constants.AddItem).click();
			int qty1 = Integer.parseInt(Qty) ;
			sumOfItemwiseMRP+=Float.parseFloat(ItemMrp.get(i))* qty1 ;
		
		
		}
		System.out.println("Total Sum of cart list considering MRP of each item :"+sumOfItemwiseMRP);
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			String ItemTotal = driver.findElementById(Constants.cartTotal).getText();
			System.out.println(ItemTotal);
			ItemTotal = ItemTotal.replaceFirst("\\W","");
			ItemTotal = ItemTotal.replaceAll(",","");
			
			ItemCartTotal = Float.parseFloat(ItemTotal);
			System.out.println(ItemCartTotal);
		}
	
	
	public void ConfirmSaleAfterItemsAdded(){
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElementById(Constants.GetPayment).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		try{
			driver.findElementById("com.c2info.ecolite:id/edit_customer_name").sendKeys("Chethan");
		driver.findElementById(Constants.prof).sendKeys("bidare");
		CF.hidekeyboard();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String TotalDiscAmtinCheckOut = driver.findElementById(Constants.DiscValueinCheckOutPage).getText();
		TotalDiscAmtinCheckOut = TotalDiscAmtinCheckOut.replace("\u20B9", "");
		TotalDiscAmtinCheckOutPage = Float.parseFloat(TotalDiscAmtinCheckOut);
		driver.findElement(By.xpath(Constants.Confirmbtn)).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.xpath(Constants.Deny)).click();
		String DiscAmt =driver.findElementById(Constants.DiscountinSuccessPage).getText();
		DiscAmt = DiscAmt.replace("\u20B9", "");
		DiscAmtInSuccessPage = Float.parseFloat(DiscAmt); 
	}
	
	public void AddNewBatch(){
		CF.hidekeyboard();
		driver.findElementById(Constants.StartButton).click();	
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.xpath(Constants.SelectSingleItem)).click();
		driver.findElementById(Constants.AddBatchLink).click();
		batchnumEntered = genData.generateRandomNumeric(5);
		driver.findElementById(Constants.AddBatch_btchNo).sendKeys(batchnumEntered);
		String BatchMRPEntered = genData.generateRandomNumeric(2);
		driver.findElementById(Constants.AddBatch_btchMRP).sendKeys(BatchMRPEntered);
		int Batchmrp = Integer.parseInt(BatchMRPEntered);
		Batchmrp = Batchmrp/2;
		String CalculatedPTR = Integer.toString(Batchmrp);
		driver.findElementById(Constants.AddBatch_PTR).sendKeys(CalculatedPTR);
		
		//Select date from Calendar
		driver.findElementById(Constants.AddBatch_Exp).click();
		driver.findElementById("android:id/date_picker_year").click();
		WebElement year = driver.findElement(By.xpath("//android.widget.TextView[@text='2018']"));
		driver.tap(1, year, 1);
		WebElement date = driver.findElement(By.xpath("//android.view.View[@index='19']"));
		driver.tap(1, date, 1);
		driver.findElementById("android:id/button1").click();
		//String ExpiryEntered = driver.findElement(By.id(Constants.AddBatch_Exp)).getText();
		
		String LooseQtyEntered= genData.generateRandomNumeric(2);
		driver.findElementById(Constants.AddBatch_LooseQty).sendKeys(LooseQtyEntered);
		CF.hidekeyboard();
		driver.findElementById(Constants.AddBatch_Btn).click();
		CheckBatch =driver.findElement(By.name(batchnumEntered)).getText();
		
	}
		//Batch verification in Item batch page
		//List<String> Batches1 = new ArrayList<String>();
	
	public void GetDetailsOfBatchAdded(){
		List<WebElement> Batches = driver.findElements(By.id(Constants.BatchCheckbox));
	
		for(WebElement we : Batches){
			if(we.isEnabled()==true){
				RetrievedBatchNum=driver.findElementById("com.c2info.ecolite:id/text_Batch_No").getText();
				
			}
			else{
				System.out.println("Batch no not found");
			}
		
		}
	}
	public void StockCheckAfterSale() throws InterruptedException{
		CF.hidekeyboard();
		driver.findElementById(Constants.StartButton).click();	
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		String itemname = driver.findElement(By.name(Constants.DummyItemName)).getText();
		System.out.println(itemname);
		driver.findElementById(Constants.GlobalSearch).sendKeys(itemname);
		String stock = driver.findElementById("com.c2info.ecolite:id/textview_itemcount").getText();
		stock = stock.replace("+", "");
		System.out.println(stock);
		int AvailableStock = Integer.parseInt(stock);
		System.out.println("Available Stock :"+AvailableStock);
		driver.findElement(By.id("com.c2info.ecolite:id/textview_itemname")).click();
		CF.hidekeyboard();
		driver.findElementById(Constants.AddItemQty).clear();
		String Qty =genData.generateRandomNumeric(1); 
		driver.findElementById(Constants.AddItemQty).sendKeys(Qty);
		int QtySold = Integer.parseInt(Qty);
		System.out.println("Qty Sold:" +QtySold);
		CF.hidekeyboard();
		driver.findElement(By.id(Constants.AddItem)).click();
		ConfirmSaleAfterItemsAdded();
		driver.findElementById(Constants.NewSaleBtn).click();
		ExpectedStockAfterSale= AvailableStock - QtySold ;
		driver.findElementById(Constants.StartButton).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		itemname = driver.findElement(By.name(Constants.DummyItemName)).getText();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElementById(Constants.GlobalSearch).sendKeys(itemname);
		stock = driver.findElementById("com.c2info.ecolite:id/textview_itemcount").getText();
		stock = stock.replace("+", "");
		ActualStockAfterSale = Integer.parseInt(stock);
		
	}
	
	public void SalesInvByDisc() throws InterruptedException{
		CF.hidekeyboard();
		driver.findElementById(Constants.StartButton).click();	
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		List<WebElement> ItemNames = driver.findElements(By.id(Constants.itemlist));
		List<String> ItemMrp = new ArrayList<String>();
		CalculatedMRPAfterDisc = 0;
		//List of web elements for item names
		for(WebElement we :ItemNames){
			Itemname.add(we.getText());
			System.out.println(Itemname);
		}
		for(int i =0;i<Itemname.size()-5;i++){
			String a = Itemname.get(i);
			driver.findElementByName(a).click();
			driver.findElementById(Constants.DiscPer).clear();
			driver.findElementById(Constants.DiscPer).sendKeys(Constants.StdDisc);
			CF.hidekeyboard();
			driver.findElementById(Constants.AddItemQty).clear();
			String Qty =genData.generateRandomNumeric(1); 
			driver.findElementById(Constants.AddItemQty).sendKeys(Qty);
			CF.hidekeyboard();
			String Disc = driver.findElementById(Constants.DiscPer).getText();
			String Itemrate =driver.findElementById(Constants.ItemBatchMRP).getText();
			driver.findElement(By.id(Constants.AddItem)).click();
			float Discount = Float.parseFloat(Disc);
			Discount = Discount/100 ;
			Itemrate = Itemrate.replaceFirst("\\W","");
			Itemrate = Itemrate.replaceAll(",", "");
			ItemMrp.add(Itemrate) ;
			int qty1 = Integer.parseInt(Qty) ;
			float ItemMRP = Float.parseFloat(ItemMrp.get(i));
		    float CalculatedItemDisc=(ItemMRP * Discount)* qty1 ;
		    CalculatedMRPAfterDisc+= (ItemMRP * qty1)- CalculatedItemDisc ;
		    CalculatedTotalDiscount+=CalculatedItemDisc ;
		
		}
		System.out.println("Calculated MRP After"+Constants.StdDisc+"%" +":"+CalculatedMRPAfterDisc);
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			String ItemTotal = driver.findElementById(Constants.cartTotal).getText();
			ItemTotal = ItemTotal.replaceFirst("\\W","");
			ItemTotal = ItemTotal.replaceAll(",","");
			ItemCartTotal = Float.parseFloat(ItemTotal);
			System.out.println(ItemCartTotal);
			ConfirmSaleAfterItemsAdded();
	}
	
	
}
