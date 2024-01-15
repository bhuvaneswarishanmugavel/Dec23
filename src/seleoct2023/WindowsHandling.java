package seleoct2023;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {
	
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\GOOD\\eclipse-workspace\\MavenNovember2023\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.flipkart.com/");
	
	driver.manage().window().maximize();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	WebElement searchEngine =driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
	searchEngine.sendKeys("iphone 15 pro max",Keys.ENTER);
	
	WebElement firstmobile = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
	firstmobile.click();
	//Parent Window ID
	String parentWindowID = driver.getWindowHandle();
	System.out.println("Parent Window ID:"+parentWindowID);
	
	//ALL WINDOWS ID
	Set<String> allWindowsID = driver.getWindowHandles();
	System.out.println("ALL WINDOWS ID:"+allWindowsID);
	
	for(String x:allWindowsID) {
		if (!parentWindowID.equals(x)) {
			System.out.println("First child ID:"+x);
			driver.switchTo().window(x);
			Thread.sleep(5000);
				}
	}
	driver.switchTo().window(parentWindowID);
	
	WebElement naturalTitanium = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]"));
	naturalTitanium.click();
	
	Set<String> allWindowsID1 = driver.getWindowHandles();
	System.out.println("ALL WINDOWS ID1:"+allWindowsID1);
	
	List<String> li=new LinkedList<String>();
	li.addAll(allWindowsID1);
	String secondWindowsID = li.get(2);
	System.out.println("Second Windows ID"+secondWindowsID);
	driver.switchTo().window(secondWindowsID);
	Thread.sleep(3000);
	driver.switchTo().window(parentWindowID);
}

}
