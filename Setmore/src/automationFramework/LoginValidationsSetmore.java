package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class LoginValidationsSetmore {

	WebDriver driver;
	String baseURL="https://www.setmore.com";
	//WebElement passwordErrorMessage

    //Verify Login With Valid credentials
	@Test(priority=0)
	public void verifyLoginWithValidCredentialsTest() {
		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriverFinal"); 
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);


		//Maximize the window
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();


		driver.findElement(By.xpath("//a[@id='button-login']")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("uma.kalyan@anywhere.co");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Search123!");
		driver.findElement(By.id("login-now")).click();


		//Locate SignOut element in accountIcon
		WebElement signoutoption=driver.findElement(By.xpath("//li[@id='sign_out']"));

		JavascriptExecutor runJS2= ((JavascriptExecutor) driver);
		runJS2.executeScript("arguments[0].click();", signoutoption);
		signoutoption.click();
		System.out.println("The setmore is logged out");


	}
   
    //Verify Login with invalid email id
	@Test(priority=1)
	public void verifyLoginWithInvalidEmailTest() throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriverFinal"); 

		// driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://my.setmore.com/logout.do";
		Assert.assertEquals(actualURL, expectedURL);
		driver.get(actualURL);


		//driver.get(baseURL+"/https://my.setmore.com/logout.do/");
		//Thread.sleep(1000);
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(username));



		username.sendKeys("uma.kalyan&anywhere.co");
		WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Search123!");
		driver.findElement(By.id("login-now")).click();


		WebElement emailError= driver.findElement(By.xpath("//div[@id='error-status']"));
		String expectedErrorMessage="Please enter a valid email address.";
		String actualErrorMessage=emailError.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

		//Assert.assertEquals(username.getAttribute(""), "The username value got cleared");
		//Assert.assertEquals(password.getAttribute(""), "The password value got cleared");

		Thread.sleep(2000);


	}
    
	//Verify Login with invalid password
	@Test(priority=2)
	public void verifyLoginWithInvalidPasswordTest() throws InterruptedException {

		driver.manage().deleteAllCookies();
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://my.setmore.com/logout.do";
		Assert.assertEquals(actualURL, expectedURL);
		driver.get(actualURL);
		//WebDriverWait wait=new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.elementToBeClickable(usernameTwo));



		WebElement usernameTwo=driver.findElement(By.xpath("//input[@id='username']"));
		WebDriverWait wait2=new WebDriverWait(driver,20);
		wait2.until(ExpectedConditions.elementToBeClickable(usernameTwo));

		usernameTwo.sendKeys("uma.kalyan@anywhere.co");
		WebElement passwordTwo= driver.findElement(By.xpath("//input[@id='password']"));
		passwordTwo.sendKeys("search123");
		WebElement loginButton=driver.findElement(By.id("login-now"));

		loginButton.click();
		System.out.println("Loggedin with incorrect password");



		WebElement passwordErrorMessage= driver.findElement(By.xpath("//div[text()='Incorrect Password. Please verify your password']"));
		//WebDriverWait wait3=new WebDriverWait(driver,20);
		//wait3.until(ExpectedConditions.textToBePresentInElement(passwordErrorMessage, "Incorrect Password. Please verify your password"));
		String expectedPwdErrorMessage="Incorrect Password. Please verify your password";
		String actualPwdErrorMessage=passwordErrorMessage.getText();
		Assert.assertEquals(actualPwdErrorMessage, expectedPwdErrorMessage);
		Thread.sleep(1000);

	}

    //Verify login with Email field as Blank
	@Test(priority=3)
	public void verifyEmailAsBlankTest() {

		driver.getCurrentUrl();

		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(username));

		username.sendKeys("");
		WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Search123!");
		driver.findElement(By.id("login-now")).click();


		WebElement emptyEmailError=driver.findElement(By.xpath("//div[@id='error-status']"));
		String expectedEmptyEmailErrorMessage="Please enter a username.";
		String actualEmptyEmailErrorMessage=emptyEmailError.getText();
		Assert.assertEquals(actualEmptyEmailErrorMessage, expectedEmptyEmailErrorMessage);
	}


	@AfterTest
	public void driverQuit() {
		driver.quit();

	}





}
