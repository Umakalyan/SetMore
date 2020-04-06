package automationFramework;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookAppointmentFromBookingPage {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","/Users/user/Downloads/chromedriverFinal");

		WebDriver driver=new  ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.setmore.com");
		driver.manage().window().maximize();


		driver.findElement(By.xpath("//a[@href='/login']")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("uma.kalyan@anywhere.co");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Search123!");
		driver.findElement(By.id("login-now")).click();


		//Verify the calendar view by default

		WebElement calendar=driver.findElement(By.xpath("//div[@id='headerNav']/h1"));


		WebDriverWait wait1= new  WebDriverWait(driver,20);
		WebElement appsIntegration= wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/profile/#configure']")));
		//a [@href="/profile/#configure"] 

		appsIntegration.click();

		//Get the oldWindow handle it stores the identity of current window 
		String oldWindow=driver.getWindowHandle();

		WebDriverWait wait2= new  WebDriverWait(driver,20);
		WebElement visitYourPage= wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'dentalabcclinic')]")));
		visitYourPage.click();

		/*getWindowHandles() stores the all the window identities open through this driver
		 handles=new+old window ...for each loop iterate till values in handles and the new window value stored 
		 in String (newWindow)....driver.switchTo().window(newWindow)->Control will move to the new Window
		 */

		Set<String> handles=driver.getWindowHandles();

		for (String newWindow : handles) {

			driver.switchTo().window(newWindow); 

		}
		//Verify the title of the Booking page
		String title=driver.getTitle();
		//System.out.println(title);
		String expectedTitle="Book an Appointment with ABC Clinic - Computers/Technology/IT - Chennai - Tamil Nadu";


		if(title.equals(expectedTitle)) {
			System.out.println("The page Title is :"+title);
		}
		else {
			System.out.println("Title does not Match");
		}

		WebElement policyBooking=driver.findElement(By.xpath("//a[@id='close-policy']"));
		policyBooking.click();

		driver.findElement(By.xpath("//ul[@id='catergoryservice']/li/div[2]/b")).click();

		WebDriverWait wait3= new  WebDriverWait(driver,20);
		WebElement dateToBeSelected= wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/table/tbody[2]/tr[2]/td[3]/a/span")));

		dateToBeSelected.click();

		//Select the time slot
		WebDriverWait wait4= new  WebDriverWait(driver,20);
		WebElement timeSlot= wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@resourcekey='r850fa96d55d972bcf45c260a0ef66b1d7a9561a2']")));
		timeSlot.click();

		driver.findElement(By.xpath("//div[@id='review_act']/following-sibling::div/div/div/div[4]")).click();

		//Find email and password
		driver.findElement(By.xpath("//input[@id='setCustEmail']")).sendKeys("customer@setmore.com");
		driver.findElement(By.xpath("//input[@id='setCustPassword']")).sendKeys("Search@0803");
		driver.findElement(By.xpath("//div[@id='setmoreLogin']")).click();

		//Finding Your Info and setting values
		driver.findElement(By.xpath("//textarea[@id='cust-Comments']")).sendKeys("Rootcanal follow up");


		driver.findElement(By.xpath("//input[@id='acceptCancellationPolicyTerms']")).click();
		driver.findElement(By.xpath("//div[@id='cust-continue']")).click();

		driver.findElement(By.xpath("//span[@id='cnfAppt']")).click();

		//Applying wait until the label Appointment Confirmed visble in the DOM
		WebDriverWait wait5= new  WebDriverWait(driver,20);
		WebElement confirmedLabel= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='step_tab']/h2")));

		if(confirmedLabel.isDisplayed()) {
			System.out.println("Appoinment Confirmed");

		}
		else {
			System.out.println("Appointment Not Confirmed");
		}

		//Applying wait until the booking Id is visble in the DOM
		WebDriverWait wait6= new  WebDriverWait(driver,20);
		WebElement bookingId= wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='confirm_ul']/li[5]/span")));

		String getbookingID=bookingId.getText();
		System.out.println("The booking Id is: "+getbookingID);

		driver.close();

		Thread.sleep(1000);

		//Move back control to the old window
		driver.switchTo().window(oldWindow);
		System.out.println("Control returns to old window");


		//Sign out -find the ACCOUNT ICON
		WebElement accountIcondd=driver.findElement(By.cssSelector("li#account_menu"));
		System.out.println("The account icon is located");


		//Locate SignOut element in accountIcon
		WebElement signoutoption=driver.findElement(By.xpath("//li[@id='sign_out']"));

		JavascriptExecutor runJS2= ((JavascriptExecutor) driver);
		runJS2.executeScript("arguments[0].click();", signoutoption);
		signoutoption.click();
		System.out.println("The setmore is logged out");


	}

}
