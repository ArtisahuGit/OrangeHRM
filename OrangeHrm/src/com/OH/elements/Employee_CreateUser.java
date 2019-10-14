package com.OH.elements;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.OH.libraries.Utility_Libraries;
import com.OH.pom.Page_Object_Model;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Employee_CreateUser {
	
	WebDriver driver;
	ExtentTest logger;
	ExtentReports Report;
	Utility_Libraries Utility_Lib = new Utility_Libraries();

	public Employee_CreateUser(WebDriver driver,ExtentTest logger,ExtentReports Report) 
		{
			this.driver = driver;
			this.logger = logger; 
			this.Report = Report;
		}
	
    public void AddUser(String SystemUserName,String SysEmployeeName,String Password,String SysUserType) throws Throwable 
		{
	    	driver.findElement(Page_Object_Model.Run("xpath","AdminTab","AddUser")).click();
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	driver.findElement(Page_Object_Model.Run("xpath","AddButton","AddUser")).click();
	    	driver.manage().timeouts().implicitlyWait(50 ,TimeUnit.SECONDS);
	    	try
	    	{
	    		//-----------------------Verification of Add User Page-------------------------------------------------------------------
	    		driver.findElement(Page_Object_Model.Run("xpath","AddUser","AddUser")).isDisplayed();
	    		Utility_Libraries.Pass_Reporter("Login", "Login successfully", "Home Page should be displayed", "Home Page is displayed", "PASS", driver, logger);
	    	}
	    	
			catch(Exception e)
			{
				Utility_Libraries.Fail_Reporter("Login", "Login successfully", "Home Page should be displayed", "Home Page is displayed", "FAIL", driver, logger,Report);
			}
	    	
	    	Select vUsername = new Select(driver.findElement(Page_Object_Model.Run("xpath","System_UserType","AddUser")));	
	    	vUsername.selectByVisibleText(SysUserType);
	    	driver.findElement(Page_Object_Model.Run("xpath","System_EmployeeName","AddUser")).sendKeys(SysEmployeeName);
			driver.findElement(Page_Object_Model.Run("xpath","System_userName","AddUser")).sendKeys(SystemUserName);
			Select vUserstatus = new Select(driver.findElement(Page_Object_Model.Run("xpath","System_UserStatus","AddUser")));
			vUserstatus.selectByIndex(0);
			driver.findElement(Page_Object_Model.Run("xpath","System_UserPassword","AddUser")).sendKeys(Password);
			driver.findElement(Page_Object_Model.Run("xpath","System_ConfirmPassword","AddUser")).sendKeys(Password);
			Thread.sleep(5000);
			driver.findElement(Page_Object_Model.Run("xpath","Save_Button","AddUser")).click();
			
			//----------------------------------------Wait statement is initialize------------------------------------
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Page_Object_Model.Run("xpath","Search_SystemUserName","SearchDelete")));
			
			//-----------------------------------------------Reporter--------------------------------------------------------------------
			Utility_Libraries.Pass_Reporter("Login", "Login successfully", "Home Page should be displayed", "Home Page is displayed", "PASS", driver, logger);
		}    
}
