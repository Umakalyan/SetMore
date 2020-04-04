package com.setmore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Acquires the BasePage property using extends 

public class LoginPage extends BasePage{

	//Finding page objects userName,passWord,signInBtn 
	@FindBy(xpath="//input[@id='username']")
	WebElement txtbox_userName;

	@FindBy(xpath="//input[@id='password']")
	WebElement txtbox_password;

	@FindBy(xpath="//a[text()='Sign In']")
	WebElement btn_signIn;

	//Initialize the LoginPage objects
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	//Actions
	public Boolean txtBoxDisplay() {
		return txtbox_userName.isDisplayed();

	}
	public Boolean pwdBoxDisplay() {
		return txtbox_password.isDisplayed();

	}
	public Boolean signInbtnDisplay() {
		return btn_signIn.isDisplayed();
	}


	public CalendarPage signIn(String usrName,String pwd) {
		txtbox_userName.sendKeys(usrName);
		txtbox_password.sendKeys(pwd);
		btn_signIn.click();
		return new CalendarPage();


	}

}
