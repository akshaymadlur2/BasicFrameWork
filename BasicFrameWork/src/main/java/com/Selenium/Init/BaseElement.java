package com.Selenium.Init;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {

	private WebElement webElement ;
	private String Object ;
	private JavascriptExecutor JsDriver ;
	
	public BaseElement(WebElement webElement, String Object) {
		// TODO Auto-generated constructor stub
		this.setWebElement(webElement);
		this.setObjectName(Object);
	}
	
	public WebElement getWebElement() {
		return webElement ;	
	}
	
	public void setWebElement(WebElement webElement) {
		this.webElement = webElement;
	}

	public String getObjectName() {
		return Object ;
	}
	
	public void setObjectName(String object) {
		this.Object = object;
	}
	
	public JavascriptExecutor getJSdriver() {
		JsDriver = (JavascriptExecutor)BrowserManager.getDriver();
		return JsDriver ;
	}
	
}
