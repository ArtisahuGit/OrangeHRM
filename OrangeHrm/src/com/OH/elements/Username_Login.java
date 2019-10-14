package com.OH.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.OH.libraries.Utility_Libraries;
import com.OH.pom.Page_Object_Model;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Username_Login {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports Report;
	
	public Username_Login(WebDriver driver,ExtentTest logger,ExtentReports Report)
		{
			this.driver = driver;
			this.logger = logger;
			this.Report = Report;
		}
	
	public void Login(String Username, String Password) throws Throwable
		{
		    //-------------------------------------Enter UserName-'Admin' -----------------------------------------------------------
				
			driver.findElement(Page_Object_Model.Run("xpath", "Login_UserName","Login")).sendKeys(Username);
			
			//-------------------------------------Enter UserName-'admin123' ---------------------------------------------------------
			driver.findElement(Page_Object_Model.Run("xpath","Login_Password","Login" )).sendKeys(Password);
			
			//-------------------------------------click login button ----------------------------------------------------------------
			driver.findElement(Page_Object_Model.Run("xpath","Login_Button","Login")).click();
			
			//------------------------------------Explicit wait------------------------------------------------------------------------
			WebDriverWait wait = new WebDriverWait(driver, 10); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(Page_Object_Model.Run("xpath","Login_Page","Login")));
			
			//--------------------------------- Verification of Login page-------------------------------------------------------------
			try
			{
				driver.findElement(Page_Object_Model.Run("xpath","Login_Page","Login")).isDisplayed();
				Utility_Libraries.Pass_Reporter("Login", "Login successfully", "Home Page should be displayed", "Home Page is displayed", "PASS", driver, logger);
				//-----------------------------------------------Reporter--------------------------------------------------------------------
			}
			catch(Exception e)
			{
				Utility_Libraries.Fail_Reporter("Login", "Login successfully", "Home Page should be displayed", "Home Page is displayed", "FAIL", driver, logger,Report);

			}
		}

}
