package com.Selenium.Init;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserManager {


    public static WebDriver driver ;

//    public static ThreadLocal<WebDriver> driver2= new ThreadLocal<>() ;

    public static WebDriver getDriver(){
        return driver;
    }

    public static void LaunchBrowser(String browser){
        String osArch = System.getProperty("os.arch");
        String osName = System.getProperty("os.name");
        if (browser.equalsIgnoreCase("CHROME")) {
            System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
            driver=new ChromeDriver();
//            driver2.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("EDGE")) {
            System.setProperty("webdriver.edge.driver","Drivers\\msedgedriver.exe");
            driver=new EdgeDriver();
//            driver.set(new EdgeDriver());
        }

        Maximize();

    }

    public static void Maximize(){
        getDriver().manage().window().maximize();
    }


    public static void CloseBrowser(){
        getDriver().quit();
    }
    
    





}
