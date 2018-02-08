package Util;

import org.automationtesting.excelreport.Xl;
import org.openqa.selenium.Dimension;

import Pages.LoginPage;

public class CommFunctions extends LoginPage{

	Dimension size;
	public void SwipeTop(){
		
		size = driver.manage().window().getSize();
		
		int starty =  (int) (size.height* 0.40);
		int endy =  (int) (size.height* 0.20);
		
		int startx = size.width/2 ;
		
		driver.swipe(startx, starty, startx, endy, 3000);
	}
	
	public void CloseApp(){
		driver.closeApp();
	}
	
	public void Resultdata() throws Exception{
		Xl.generateReport("TC Results.xlsx");
	}
	
	public void hidekeyboard(){
		try{
			driver.hideKeyboard();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
