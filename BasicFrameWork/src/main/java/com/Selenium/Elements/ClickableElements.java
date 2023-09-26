package com.Selenium.Elements;

import org.openqa.selenium.WebElement;

import com.Selenium.Init.BaseElement;

public class ClickableElements extends BaseElement{

	public ClickableElements(WebElement webElement, String Object) {
		super(webElement, Object);
		// TODO Auto-generated constructor stub
	}
	
	public void Click() {
		getWebElement().click();
	}
	
	public void JSClick() {
		getJSdriver().executeScript("arguments[0].click();", getWebElement());
	}

}
