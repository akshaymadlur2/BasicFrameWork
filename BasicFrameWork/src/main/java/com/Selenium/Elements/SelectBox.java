package com.Selenium.Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Selenium.Init.BaseElement;

public class SelectBox extends BaseElement{
	
	private Select select ;

	public SelectBox(WebElement webElement, String Object) {
		super(webElement, Object);
         select = new Select(webElement);
	}
	
	public void SelectByVisibleText(String VisibleText) {
		select.selectByVisibleText(VisibleText);
	}
	
	public void SelectByValue(String Value) {
		select.selectByValue(Value);
	}
	
	public void SelectByIndex(int Index) {
		select.selectByIndex(Index);
	}

}
