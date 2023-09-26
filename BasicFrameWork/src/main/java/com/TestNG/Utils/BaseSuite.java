package com.TestNG.Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Selenium.Init.BrowserManager;
import com.Selenium.Utils.ExcelReadAndWrite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class BaseSuite {

	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	String timestamp = new SimpleDateFormat("_dd.MMM.yy_HH.mm z").format(new Date());
	static String excelFilePath = System.getProperty("user.dir") + "\\DataFolder\\TestingData.xlsx";
	static String sheetName = "Excel";
	static String Column = "Aks";
	public Recordset data;

	@BeforeSuite
	@Parameters({ "browser", "Column" })
	public void Launch(@Optional String browser, String Column) throws FilloException {
		BrowserManager.LaunchBrowser(browser);
		data = ExcelReadAndWrite.ReadExcelData(excelFilePath, sheetName, Column);
		data.next();
	}

	@BeforeSuite
	public void Report() {
		report = new com.aventstack.extentreports.ExtentReports();

		spark = new ExtentSparkReporter(new File("./ExtentReports/AutomationReport_Aks" + timestamp + ".html"))
				.viewConfigurer().viewOrder()
				.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();
//		  test = report.createTest("");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Testing");
		spark.config().setReportName("Face_Book Testing");
		report.setSystemInfo("Company Name", "FaceBook_Company");
		report.setSystemInfo("Tester Name", "Guna");
		report.attachReporter(spark);

	}

	@AfterSuite
	public void tearDown() {
		BrowserManager.CloseBrowser();
		report.flush();
//		Desktop.getDesktop().browse(new File("ExtentReports/Automation_Report" + timestamp + ".html").toURI());

	}

}
