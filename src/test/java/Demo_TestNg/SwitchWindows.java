package Demo_TestNg;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SwitchWindows
{
	public static String parentWindowId;
	public static void main(String[]args) throws InterruptedException
	{

	
	ChromeOptions options=new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("disable-infobars");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-notifications");
    options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
    

    WebDriver driver=new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://www.bus.irctc.co.in/home"); 
    
    driver.findElement(By.cssSelector("div[class='Nav-icons IRCTCHotels']")).click();
    driver.findElement(By.cssSelector("div[class='Nav-icons Package']")).click();
    driver.findElement(By.cssSelector("div[class='Nav-icons RetiringRoom']")).click(); 
    
    parentWindowId=driver.getWindowHandle();
	Set<String> WindowIds= driver.getWindowHandles();
	System.out.println("parent id : " +parentWindowId);
	System.out.println("window id : " +WindowIds);
		for (String windowid : WindowIds) {
			driver.switchTo().window(windowid);
			if(driver.getTitle().contains("RetiringRoom")) {
			break; }
		}
		driver.switchTo().window(parentWindowId);
		Thread.sleep(5000);
		//driver.quit();
	
}
   
	/*
	 * Set<String> handles=driver.getWindowHandles();//parentclass and child
	 * classes. Iterator it=handles.iterator(); String parentid=(String) it.next();
	 * String childid=(String) it.next();
	 * 
	 * driver.switchTo().window(childid); System.out.println("Child id:"+childid);
	 * 
	 * 
	 * driver.switchTo().window(parentid);
	 * System.out.println("Parent id:"+parentid);
	 * 
	 */
}
	
