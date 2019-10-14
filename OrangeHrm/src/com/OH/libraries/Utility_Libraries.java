package com.OH.libraries;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utility_Libraries {
	
	static String Folder_path = System.getProperty("user.dir")+"\\src\\TestResult\\Report"+Utility_Libraries.Time_stamp();
	
	public static WebDriver Launch(String browser, String URL, WebDriver driver)
	{
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.navigate().to(URL);
			driver.manage().window().maximize();
			return driver;
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\iDeliver20\\Desktop\\Driver\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to(URL);
			driver.manage().window().maximize();
			return driver;
		}
		else {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\iDeliver20\\Desktop\\Driver\\chromedriver\\chromedriver.exe");
			driver = new InternetExplorerDriver();
			driver.navigate().to(URL);
			driver.manage().window().maximize();
			return driver;
		}
	}
		
	public static String getScreenshot(WebDriver driver) throws Throwable
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			File Destination = new File(Folder_path+"\\Screenshot"+Utility_Libraries.Time_stamp()+".png");		
			FileUtils.copyFile(Source, Destination);	
			return ""+Destination;
		}
		
	public static ExtentReports Create_Report() throws Exception
		{
			ExtentReports extent = new ExtentReports(Folder_path+"\\Report"+Utility_Libraries.Time_stamp()+".html");
			return extent;
		}
	
	public static String Time_stamp()
		{
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
			String time = dateFormat.format(now);
			return time;
		}
		
	public static String GetElement(String Keys,String OR_name) throws Throwable
		{
			FileInputStream pagobj = new FileInputStream (System.getProperty("user.dir") + "\\src\\com\\OH\\properities\\"+OR_name+".Properties");	
			Properties obj = new Properties();
			obj.load(pagobj);
			return obj.getProperty(Keys);
		}
		
	public static void Pass_Reporter(String Step_Name,String Step_details,String Expected,String Actual,String Status,WebDriver driver, ExtentTest logger) throws Throwable
		{
			logger.log(LogStatus.INFO, Step_Name, Step_details);
			logger.log(LogStatus.PASS,Step_details,logger.addScreenCapture(Utility_Libraries.getScreenshot(driver)));
			Excel_Libraries.Excel_Reporter(Step_Name,Step_details,Expected,Actual,Status);
		}
		
	public static void Fail_Reporter(String Step_Name,String Step_details,String Expected,String Actual,String Status,WebDriver driver, ExtentTest logger, ExtentReports Report ) throws Throwable
		{
			logger.log(LogStatus.INFO, Step_Name, Step_details);
			logger.log(LogStatus.FAIL,Step_details,logger.addScreenCapture(Utility_Libraries.getScreenshot(driver)));
			Excel_Libraries.Excel_Reporter(Step_Name,Step_details,Expected,Actual,Status);
			Report.endTest(logger);
			Report.flush();
			System.exit(0);
			driver.close();
		}
		
	}


