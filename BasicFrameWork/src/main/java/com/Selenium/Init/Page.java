package com.Selenium.Init;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class Page{

    static WebDriver driver=BrowserManager.getDriver();

    
	public Page() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(BrowserManager.getDriver(), this);
	}
	
	public  void OpenUrl(String Url) {	
		driver.get(Url);
	}
	
	public void MouseHover(WebElement element) {
		Actions action= new Actions(driver)  ;
	    action.moveToElement(element).build().perform();
	}
	
	public void RightClick(WebElement element) {
		Actions action= new Actions(driver)  ;
		action.contextClick(element).build().perform();
	}
	
	public void ScrollToElement(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView.true();", element);
		
	}
	
}
