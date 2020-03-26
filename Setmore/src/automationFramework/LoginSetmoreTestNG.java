package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LoginSetmoreTestNG {

	//public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "/Users/user/Downloads/chromedriverFinal";
    public WebDriver driver ; 
     
	

	@Test
	public void f() {

		driver.findElement(By.xpath("//div[@id='button-login']/a")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("uma.kalyan@anywhere.co");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Search123!");
		driver.findElement(By.id("login-now")).click();
		
		




	}
	@BeforeMethod
	public void beforeMethod() {

		driver=new ChromeDriver();

		driver.get("https://www.setmore.com");

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
