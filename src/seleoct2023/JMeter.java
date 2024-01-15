package seleoct2023;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JMeter {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\GOOD\\eclipse-workspace\\MavenNovember2023\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement jMeterFrame = driver.findElement(By.id("a077aa5e"));
		//SWITCH TO JMETER FRAME
		driver.switchTo().frame(jMeterFrame);
		
		WebElement jmeter = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
		jmeter.click();
		
		//TO FIND PARENT WINDOWS ID
		String parentWindowID = driver.getWindowHandle();
		System.out.println("parentwindowID is:"+parentWindowID);
		
		Set<String> allWindowsID = driver.getWindowHandles();
		System.out.println("All WindowsID are:"+allWindowsID);
		
		for(String x:allWindowsID) {
			if(!parentWindowID.equals(x)) {
				System.out.println("First Child Window:"+x);
				driver.switchTo().window(x);
			}
		}
		
		
	}

}
