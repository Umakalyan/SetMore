package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLogin {
 
	
	//Pass multiple values using DataProvider
	String data[][]= {
		{"uma.kalyan@anywhere.co","Search123!"},
		{"umavasanth27@gmail.com","Search@0803"}
	};
	
	@DataProvider(name="loginData")
	public String[][] login() {
		
		return data;
		
	}
	   
	   @Test(dataProvider="loginData")
	  public void login(String userName,String passWord) {
			System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriverFinal"); 
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.setmore.com");


			//Maximize the window
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();


			driver.findElement(By.xpath("//a[@id='button-login']")).click();

			WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
			username.sendKeys(userName);
			WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
			password.sendKeys(passWord);
			driver.findElement(By.id("login-now")).click();
			driver.close();
		

  }
	   
}
