package automationFramework;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationsHierarchy {

	//Demo for TestAnnotations @BeforeMethod,@AfterMethod,@Test,BeforeTest and AfterTest and priority-1,SoftAssertion,HardAssert

	public String baseUrl = "https://www.setmore.com/";
	String driverPath = "/Users/user/Downloads/chromedriverFinal";
	public WebDriver driver ; 
	public String expected=null;
	public String actual=null;


	@BeforeMethod
	public void beforeMethod() {

		String expectedTitle="Free Online Appointment Scheduling Calendar Software | Setmore";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

		System.out.println("Before Method--->The title  is :"+actualTitle); 

	}//HardAssert()
	@Test(priority=-1)
	public void LoginTest() {
		driver.findElement(By.xpath("//a[@id='button-login']")).click();
		String expected="Free Online ppointment Software for Small Business - Login";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		System.out.println("The title is :" +actual);//


	}
	//SoftAssert()
	@Test(priority=0)
	public void StartNow() {

		driver.findElement(By.xpath("//button[@id='button-signup']/a")).click();
		SoftAssert softAssertion= new SoftAssert();

		String expected="Sign Up for ree Online Appointment Scheduling | Setmore";
		String actual=driver.getTitle();
		softAssertion.assertEquals(actual, expected);
		System.out.println("SoftAssertUsed so this statement going to be executed ---->The title is :" +actual);

	}
	@AfterMethod

	public void afterMethod() {
		driver.findElement(By.xpath("//a[@id='logo-home']")).click();


	}


	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver= new ChromeDriver();
		driver.get(baseUrl);

	}

	@AfterTest
	public void terminateBrowser() {

		driver.close();


	}


}
