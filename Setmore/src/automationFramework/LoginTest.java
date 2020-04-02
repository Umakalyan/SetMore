package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//This code reduces the Webdriver object is declared,url launch,browser close for each and every test  
public class LoginTest extends BaseClass{


	@Test(priority=0)
	public void loginValidCredentials() {

		driver.findElement(By.xpath("//a[@id='button-login']")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("uma.kalyan@anywhere.co");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Search123!");
		driver.findElement(By.id("login-now")).click();

	}

	@Test(priority=1)
	public void calendarPageTitle() {
		String expected="Setmore Calendar";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		System.out.println("The title is :" +actual);

	}

	@Test(priority=2)
	public void signOut() {
		//Locate SignOut element in accountIcon
		WebElement signoutoption=driver.findElement(By.xpath("//li[@id='sign_out']"));

		JavascriptExecutor runJS2= ((JavascriptExecutor) driver);
		runJS2.executeScript("arguments[0].click();", signoutoption);
		signoutoption.click();
		System.out.println("The setmore is logged out");
		driver.navigate().to("https://my.setmore.com/logout.do");

	}
	@Test(priority=3)
	public void loginInValidCredentials() {

		driver.getCurrentUrl();
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(username));



		username.sendKeys("uma.kalyan$anywhere.co");
		WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Search123!");
		driver.findElement(By.id("login-now")).click();



		WebElement emailError= driver.findElement(By.xpath("//div[@id='error-status']"));
		String expectedErrorMessage="Please enter a valid email address.";
		String actualErrorMessage=emailError.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		username.clear();
		password.clear();

		System.out.println("The error message is :"+actualErrorMessage);

	}

	@Test(priority=4)
	public void loginInvalidPassword() throws InterruptedException {


		driver.getCurrentUrl();


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
		System.out.println(actualPwdErrorMessage);
		Thread.sleep(1000);
	}


}
