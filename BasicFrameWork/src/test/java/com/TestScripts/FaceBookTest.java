package com.TestScripts;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.FacebookPage;
import com.Selenium.Init.BrowserManager;
import com.Selenium.Init.Page;
import com.Selenium.Utils.ScreenShot;
import com.TestNG.Utils.BaseSuite;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.codoid.products.exception.FilloException;

public class FaceBookTest extends BaseSuite{
	
	
	FacebookPage fb ;

	public void init() {
		fb= new FacebookPage() ;
	}
	
	
	
    @Test(enabled = true)
    public void login() throws IOException, InterruptedException {
        init();
        test = report.createTest("FB Login Check");
        test.log(Status.INFO, "Test Case-1");
        test.log(Status.INFO, MarkupHelper.createLabel("Browser launched", ExtentColor.BLACK));
        test.log(Status.INFO, MarkupHelper.createLabel("maximize has done", ExtentColor.BLUE));

        fb.OpenUrl("https://www.facebook.com/");

        test.log(Status.PASS, MarkupHelper.createLabel("Url is opened", ExtentColor.GREEN));
        fb.ClickOnRegistration();

        Thread.sleep(3000);
//        if(fb.RadioBtn2.isEnabled()){
//
//        test.log(Status.PASS, MarkupHelper.createLabel("Radio button selected", ExtentColor.GREEN));
//        }
//        else {
//        	 test.log(Status.INFO, MarkupHelper.createLabel("Radio button not selected", ExtentColor.RED));
//             
//        }

        fb.ClickOnRadio1() ;

//        if(fb.RadioBtn1.isEnabled()){
//        Thread.sleep(3000);
//        test.log(Status.PASS, MarkupHelper.createLabel(" 2nd Radio button selected", ExtentColor.GREEN));
//        }
//        else {
//       	 test.log(Status.INFO, MarkupHelper.createLabel("2nd Radio button not selected", ExtentColor.RED));
//            
//       }
        test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenShot("Photo")).build());

        test.addScreenCaptureFromPath( ScreenShot.TakeScreenShot("Photo"),"ScreenShot is Done");
        fb.EnterFirstname("Automation");
        Thread.sleep(3000);
        fb.EnterLastname("Selenium");
        test.log(Status.PASS, MarkupHelper.createLabel("closed the browser", ExtentColor.BLUE));
        test.log(Status.INFO, MarkupHelper.createLabel("test completed", ExtentColor.BLACK));

    }
    @Test(enabled = true)
    @Parameters({"browser"})
    public void Test(String browser) throws FilloException {
    	
    	System.out.print(data.getField("Username"));
    	System.out.print(data.getField("Password"));
    	System.out.print(data.getField("Name"));
		
	}


}
