package com.setmore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	//HomePage Objects
	@FindBy(xpath="//a[@id='button-login']")
	WebElement login;	

	@FindBy(xpath="//a[text()='START NOW']")
	WebElement startNow;


	//Initialize the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	//Actions
	public LoginPage loginButton() {
		login.click();
		return new LoginPage();
	}


	public SignUpPage clickStartNow() {
		startNow.click();

		return new SignUpPage();
	}

}




