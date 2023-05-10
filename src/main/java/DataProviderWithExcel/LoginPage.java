package DataProviderWithExcel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	
	/*
	 * By user=By.cssSelector("div input[name=username]"); By
	 * pass=By.cssSelector("div input[name=password]"); By
	 * loginbtn=By.cssSelector("div button[class*='oxd-button']");
	 */
	
	By user=By.cssSelector("div.form-group input[id='username']");
	By pass=By.cssSelector("div.form-group input[id='password']");
	By loginbtn=By.cssSelector("button[id='loginbtn']");
	
	
	WebDriver driver=DriverManager.getdriver();

	public LoginPage openURL(String url) {
		driver.get(url);
		return this;}
		
	public LoginPage Enterusername (String username) {
		driver.findElement(user).sendKeys(username);
		return this;
	}	
	public LoginPage Enterpassword (String password) {
		driver.findElement(pass).sendKeys(password);
		return this;
	}
	public HomePage Clicklogin() {
		driver.findElement(loginbtn).click();;
		return new HomePage();
	}
	
	}