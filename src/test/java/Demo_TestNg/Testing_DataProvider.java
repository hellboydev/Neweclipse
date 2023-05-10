package Demo_TestNg;

import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import DataProviderWithExcel.DataReader;
import DataProviderWithExcel.HomePage;
import DataProviderWithExcel.LoginPage;


public class Testing_DataProvider {
	DataReader rd = new DataReader();

	@Test(dataProvider = "container")
	public void test(String username, String password) throws InterruptedException {
		LoginPage lp = new LoginPage();
		HomePage hp = new HomePage();

//	lp.openURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		lp.openURL("https://online.btes.co.in/login/index.php");

		Thread.sleep(5000);
		
		 lp.Enterusername(username); lp.Enterpassword(password); hp=lp.Clicklogin();
		 Thread.sleep(1000);
		 
		 System.out.println("Finish");
		 
		 
			/*
			 * Alert alert = DriverManager.getDriver().switchTo().alert(); if (alert !=
			 * null) {
			 * 
			 * String alertData = alert.getText(); System.out.println(alertData);
			 * alert.dismiss(); alert.accept(); }
			 */

	}

	@DataProvider(name = "container")
	public Object[][] gettest() throws IOException {
		return rd.getdetails();

	}

}
