package com.OH.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OH.libraries.Utility_Libraries;
import com.OH.pom.Page_Object_Model;
import com.relevantcodes.extentreports.ExtentTest;

public class Employee_SearchDeleteUser {
		WebDriver driver;
		ExtentTest logger;
		Utility_Libraries Utility_Lib = new Utility_Libraries();

	public Employee_SearchDeleteUser(WebDriver driver,ExtentTest logger) 
		{
			this.driver = driver;
			this.logger = logger;
		}
	
	public void SearchDeleteUser(String SystemUserName,String SysEmployeeName,String SysUserType) throws Throwable 
		{
		    //----------------------------------------Wait statement is initialize------------------------------------
			WebDriverWait wait = new  WebDriverWait(driver,20);
			
			driver.findElement(Page_Object_Model.Run("xpath","Search_SystemUserName","SearchDelete")).sendKeys(SystemUserName);
			Select vSearchUsername = new Select(driver.findElement(Page_Object_Model.Run("xpath","Search_SystemUserType","SearchDelete")));	
			vSearchUsername.selectByVisibleText(SysUserType);
			driver.findElement(Page_Object_Model.Run("xpath","Search_SystemEmployeeName","SearchDelete")).sendKeys(SysEmployeeName);
			Select vSearchUserstatus = new Select(driver.findElement(Page_Object_Model.Run("xpath","Search_SystemUserStatus","SearchDelete")));
			vSearchUserstatus.selectByIndex(1);
			driver.findElement(Page_Object_Model.Run("xpath","Search_Button","SearchDelete")).click();
			Thread.sleep(5000);
			driver.findElement(Page_Object_Model.Run("xpath","Select_Record","SearchDelete")).click();
			driver.findElement(Page_Object_Model.Run("xpath","Delete_Button","SearchDelete")).click();
			
			//--------------------------------------Explicit wait-------------------------------------------------------------------------
			wait.until(ExpectedConditions.visibilityOfElementLocated(Page_Object_Model.Run("xpath","Dialog_DeleteButton","SearchDelete")));
			
			driver.findElement(Page_Object_Model.Run("xpath","Dialog_DeleteButton","SearchDelete")).click();
			
			//-----------------------------------------------Reporter--------------------------------------------------------------------
			Utility_Libraries.Pass_Reporter("Login", "Login successfully", "Home Page should be displayed", "Home Page is displayed", "PASS", driver, logger);
		}
}
