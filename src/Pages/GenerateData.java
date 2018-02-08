package Pages;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateData extends LoginPage {

	public String generateRandomString(int length){
		return RandomStringUtils.randomAlphabetic(length);
	}
	public String generateRandomNumeric(int length){
		String allowedChars = "123456789";
		String No =RandomStringUtils.random(length,allowedChars) ;
		
		return No;
		 
	}
	
	public String generateEmailID(int length){
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "0987654321" + "_.-"  ;
		String email = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		email = temp.substring(0, temp.length()-9)+"@csquare.com";
		return email;
	}
}
