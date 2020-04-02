package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;
	public String browser="chrome";

   String baseUrl;
	@BeforeClass
	public void setupApplication()
	{
		if(driver==null) {
			if(browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriverFinal");
				driver=new ChromeDriver();

			}else if (browser.equals("firefox")) {

				System.setProperty("webdriver.gecko.driver", "");


			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			driver.get("https://www.setmore.com");

		}
	}/*
	    public String baseUrl()
	    {
	    return driver.getCurrentUrl();
	    }*/
	


	@AfterClass
	public void closeApplication()
	{
		driver.quit();

	}



}
