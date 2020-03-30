package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginWithParameter {
	//Parameterization from TestNGXML
	
	public String baseUrl = "https://www.setmore.com/";
	String driverPath = "/Users/user/Downloads/chromedriverFinal";
	public WebDriver driver ; 
	
  @Test
  @Parameters({"Username","Password"})
  public void LoginTest(String Username,String Password) {
	  
	  driver.findElement(By.xpath("//a[@id='button-login']")).click();
	  WebElement usernametxt=driver.findElement(By.xpath("//input[@id='username']"));
	  usernametxt.sendKeys(Username);
	  WebElement pwdtext=driver.findElement(By.xpath("//input[@id='password']"));
	  pwdtext.sendKeys(Password);
	  
	  driver.findElement(By.xpath("//a[@id='login-now']")).click();

	  
  }
  
  @Test
  public void calendarPage() {
	  String expectedTitle="Setmore Calendar";
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
	  System.out.println("The Calendar title is:" +actualTitle);
	  
  }
  @BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

	}

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
