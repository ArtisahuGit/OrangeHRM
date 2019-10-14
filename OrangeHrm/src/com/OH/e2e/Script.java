package com.OH.e2e;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.OH.elements.Employee_CreateUser;
import com.OH.elements.Employee_SearchDeleteUser;
import com.OH.elements.Username_Login;
import com.OH.libraries.Excel_Libraries;
import com.OH.libraries.Utility_Libraries;
import com.OH.pom.Page_Object_Model;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Script {
	
	   //------------------------------------------Create object------------------------------------------- 
		WebDriver driver;
		ExtentReports Report;
		ExtentTest logger;
		
		//------------------------------------------Declare String------------------------------------------- 
		String SystemUserName = "ORH" + new Random().nextInt(1000);
		String testName;
		
		@BeforeSuite
		public void Create() throws Exception
			{
			    //--------------------------------------------Calling report-----------------------------------------------------
				Report = Utility_Libraries.Create_Report();
				
				//----------------------------------------------Start report test-------------------------------------------------
				testName = new Object(){}.getClass().getEnclosingMethod().getName();
				logger=Report.startTest(testName);
			}
		
		@Test(priority=1)
		@Parameters("browser")
		public void LaunchApplication(String browser) throws Throwable
		    {
				//----------------------------------------------Start report test-------------------------------------------------
				testName = new Object(){}.getClass().getEnclosingMethod().getName();
				logger=Report.startTest(testName);
				
				String URL="https://opensource-demo.orangehrmlive.com/";
				//--------------------------------Calling Launch Method-------------------------------------------------------------
				driver = Utility_Libraries.Launch(browser, URL, driver);
				
				//--------------------------Verification URL of Application--------------------------------------------------------
				if(driver.getCurrentUrl().contentEquals(URL))
					{
					    //-----------------------------------------------Reporter--------------------------------------------------------------------
						Utility_Libraries.Pass_Reporter("Login", "Login successfully", "Home Page should be displayed", "Home Page is displayed", "PASS", driver, logger);
					}
				else
					{
						Utility_Libraries.Fail_Reporter("Login", "Login successfully", "Home Page should be displayed", "Home Page is displayed", "FAIL", driver, logger,Report);
					}
		    }
		
//		@Test(dataProvider="Login",priority=2)
//		public void Login(String Username, String Password) throws Throwable 
//			{
//			    //----------------------------------------------Start report test-------------------------------------------------
//				testName = new Object(){}.getClass().getEnclosingMethod().getName();
//				logger=Report.startTest(testName);
//			
//				//--------------------------------Calling Login Method-------------------------------------------------------------
//				Username_Login LoginObj = new Username_Login(driver,logger,Report);
//				LoginObj.Login(Username, Password); 
//			}
//	
//		@DataProvider(name="Login")
//		public Object[][] getDataFromDataprovider()
//		   {
//			   return new Object[][] 
//			   {
//				 { "Admin", "admin123" }  ,
//				 //{ "Arti", "admin123" }  
//			   };
//		   }
//		      
//		@Test(priority=3)
//		@Parameters({"Password","SysUserType"})
//		
//		public void CreateUser(String Password,String SysUserType) throws Throwable 
//		   {
//				//----------------------------------------------Start report test-------------------------------------------------
//				testName = new Object(){}.getClass().getEnclosingMethod().getName();
//				logger=Report.startTest(testName);
//				
//				//--------------------------------Excel Reading-------------------------------------------------------------------
//				String SysEmployeeName = Excel_Libraries.Read_Excel("EmployeeName");
//				 
//				//--------------------------------Calling AddUser Method----------------------------------------------------------
//				Employee_CreateUser CreateUserObj = new Employee_CreateUser(driver,logger,Report);
// 			  	CreateUserObj.AddUser(SystemUserName,SysEmployeeName,Password,SysUserType);
//		   }
//			  
//		@Test(priority=4)
//		@Parameters("SysUserType")
//		public void SearchDeleteUser(String SysEmployeeName,String SysUserType) throws Throwable 
//		  {		
//			   //----------------------------------------------Start report test-------------------------------------------------------
//				testName = new Object(){}.getClass().getEnclosingMethod().getName();
//				logger=Report.startTest(testName);
//				
//				//--------------------------------Excel Reading------------------------------------------------------------------------
//				String SysSearchEmployeeName = Excel_Libraries.Read_Excel("EmployeeName");
//				
//				//--------------------------------Calling SearchDeleteUser Method-------------------------------------------------------
//		     	Employee_SearchDeleteUser SearchDeleteObj = new Employee_SearchDeleteUser(driver,logger);
//		     	SearchDeleteObj.SearchDeleteUser(SystemUserName, SysSearchEmployeeName,SysUserType);	
//		  }
//		  
//		@Test(priority=5)
//		public void CloseApplication() throws Throwable
//		  {	
//				//----------------------------------------------Start report test-------------------------------------------------
//				testName = new Object(){}.getClass().getEnclosingMethod().getName();
//				logger=Report.startTest(testName);
//				
//				//-----------------------------------------------Logout-----------------------------------------------------------
//				driver.findElement(Page_Object_Model.Run("xpath","Logout_Click","Login" )).click();
//				Thread.sleep(2000);
//				driver.findElement(Page_Object_Model.Run("xpath","Logout","Login" )).click();
//				
//				try
//				{
//					driver.findElement(Page_Object_Model.Run("xpath","Login_Password","Login" )).isDisplayed();
//					
//					  //-----------------------------------------------Reporter--------------------------------------------------------------------
//					Utility_Libraries.Pass_Reporter("Logout", "Logout successfully", "Login Page should be displayed", "Login Page is displayed", "PASS", driver, logger);
//					driver.close();	
//				}
//				catch(Exception e)
//				{
//					Utility_Libraries.Fail_Reporter("Logout", "Logout successfully", "Login Page should be displayed", "Login Page is displayed", "FAIL", driver, logger,Report);
//				}	
//		  }
//		
//		@AfterMethod
//		public void Flush() throws Throwable
//		  {
//			Report.endTest(logger);
//			Report.flush();
//		  }
}




