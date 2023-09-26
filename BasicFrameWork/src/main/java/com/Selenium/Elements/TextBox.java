package com.Selenium.Elements;

import org.openqa.selenium.WebElement;

import com.Selenium.Init.BaseElement;

public class TextBox extends BaseElement{

	public TextBox(WebElement webElement, String Object) {
		super(webElement, Object +"Text Box");
		// TODO Auto-generated constructor stub
	}
	
	public void EnterValue(String Value) {
		getWebElement().sendKeys(Value);
	}
	
	public void EnterJSValue(String Value) {
		getJSdriver().executeScript("arguments[0].value='"+Value+"'", getWebElement());
	}

}
