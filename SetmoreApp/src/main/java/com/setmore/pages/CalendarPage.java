package com.setmore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//Acquires the BasePage property using extends 
public class CalendarPage extends BasePage{

	@FindBy(xpath="//div[@id='headerNav']/h1")
	WebElement pageHeader;

	//Initialize the LoginPage objects
	public CalendarPage() {
		PageFactory.initElements(driver, this);

	}

	//Actions
	public String pageTitle() {

		return driver.getTitle();
	}


	public  String pageHeaderCheck() {
		return pageHeader.getText();
	}


}
