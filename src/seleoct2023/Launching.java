package seleoct2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launching {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\GOOD\\DECGITHUB23\\Dec23\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	
	WebElement fbuser = driver.findElement(By.id("email"));
	fbuser.sendKeys("vedha@gmail.com");
	String text=fbuser.getAttribute("value");
	System.out.println(text);
	System.out.println("USERID SEND SUCCESSFULLY");

	
	WebElement password = driver.findElement(By.id("pass"));
	password.sendKeys("1234567");	
	String attribute = password.getAttribute("value");
	System.out.println(attribute);
	System.out.println("PASSWORD SEND SUCCESSFULLY");
	Thread.sleep(2000);
	
	WebElement facebooktext = driver.findElement(By.xpath("//h2[contains(text(),'helps')]"));
	String text2 = facebooktext.getText();
	System.out.println(text2);
	WebElement click = driver.findElement(By.xpath("//button[@data-testid='royal_login_button']"));
	click.click();
	
	
	
	
	
	
	
	
}
}
