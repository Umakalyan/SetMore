package com.setmore.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {


	//Initialize the Chrome Driver,Browser,application URL
	public static WebDriver driver;
	public String browser="chrome";

	public BasePage() {
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
	}

	public String getURL() {
		return driver.getCurrentUrl();

	}
	public void closeApplication()
	{
		driver.quit();

	}


}
