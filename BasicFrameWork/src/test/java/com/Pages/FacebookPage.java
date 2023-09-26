package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Selenium.Elements.ClickableElements;
import com.Selenium.Elements.TextBox;
import com.Selenium.Init.Page;

public class FacebookPage extends Page{

	
	@FindBy(xpath = "//a[@data-testid='open-registration-form-button']")
	public WebElement Registration ;
	
	@FindBy(xpath = "(//input[@name='sex'])[2]")
	public WebElement RadioBtn2 ;
	
	@FindBy(xpath = "(//input[@name='sex'])[1]")
	public WebElement RadioBtn1 ;
	
	@FindBy(xpath = "//input[@name='firstname']")
	public WebElement FirstName ;
	
	@FindBy(xpath = "//input[@name='lastname']")
	public WebElement LastName ;
	
	public void ClickOnRegistration() {
		new ClickableElements(Registration, "Click On Registration").JSClick();
	}
	
	public void ClickOnRadio2() {
		new ClickableElements(RadioBtn2, "Click On RadioBtn2").Click();
	}
	
	public void ClickOnRadio1() {
		new ClickableElements(RadioBtn1, "Click On RadioBtn1").Click();		
	}
	
	public void EnterFirstname(String value) {
		new TextBox(FirstName, "Enter FirstName").EnterJSValue(value);
	}
	
	public void EnterLastname(String value) {
		new TextBox(LastName, "Enter LastName").EnterValue(value);
		
	}

}
