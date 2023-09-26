package com.Selenium.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Selenium.Init.BrowserManager;

public class ScreenShot {
	
	
	static String timestamp =new SimpleDateFormat("_dd.MMM.yy_HH.mm z").format(new Date());
	
	
	
	public static String TakeScreenShot(String Name) throws IOException {
        TakesScreenshot obj =  (TakesScreenshot) BrowserManager.getDriver() ;
        File srcFile= obj.getScreenshotAs(OutputType.FILE);
        String destfile= System.getProperty("user.dir")+"/ScreenShots/"+Name+""+timestamp+".png";
        FileUtils.copyFile(srcFile,new File(destfile));
//        File dest=new File("./ScreenShots/"+timestamp+".png");
//        FileUtils.copyFile(srcFile,dest);
        return destfile ;

    }

	
}