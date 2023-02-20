package QA;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SmokeTest

  {
	
	 WebDriver driver;
	 
	Test_Data testdata = new Test_Data();
	@Parameters ("browser")
	@BeforeMethod
	public void Before_Methord(String browser) throws InterruptedException {
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
		System.out.println("launching Chrome browser");
//		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.out.println("launching Edge Browser");
//			System.setProperty("webdriver.chrome.driver", driverPath);
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
	}
	
	@Test
	public void verify_IMDI_Page() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Page_Class_IMDB obj_1 = new Page_Class_IMDB(driver);
		
		String baseUrl = testdata.IMDB_Base_Url;
		driver.get(baseUrl);
		driver.manage().window().maximize();
	//	Thread.sleep(10000);
		
		obj_1.enter_Text_in_SearchBox(testdata.IMDB_search_Box_Input);
		
		// puspa: The Rise
		
	//	Thread.sleep(5000);
		
		obj_1.click_on_ListItem();
		
		Thread.sleep(5000);

	     String	Expected_Release_Date = obj_1.Get_Release_Date();
	     System.out.println("Expected Relese Date is ::  " +testdata.IMDB_release_Date_Actual_Value);
         Assert.assertEquals(Expected_Release_Date, testdata.IMDB_release_Date_Actual_Value, " Release date is Not as per expected");
		
		
	// as per browser setting we are getting usa instead of India in the above code.
	//	December 17, 2021 (India)
		
		
		String	Expected_Country_Name = obj_1.Get_Country_Of_Origen();
		System.out.println("Country of Origin is ::  " +testdata.IMDB_country_Actual_Value);		
	    Assert.assertEquals(Expected_Country_Name, testdata.IMDB_country_Actual_Value, " Country Name is not as per expected");
			
		
	  }
	
	
	
	@Test
	public void verify_WIKI_Page() throws InterruptedException 
	
	 {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Page_Class_WIKI obj3 = new Page_Class_WIKI(driver);
		
		String baseUrl = testdata.WIKI_Base_Url;
		driver.get(baseUrl);
		driver.manage().window().maximize();
//		Thread.sleep(10000);
		
		obj3.enter_Text_in_SearchBox(testdata.WIKI_search_Box_Input);
		
//		Thread.sleep(5000);
		
		obj3.click_on_ListItem();
		
//		Thread.sleep(5000);
		

	     String	Expected_Release_Date = obj3.Get_Release_Date();
	     System.out.println("Expected Relese Date is ::  " +testdata.WIKI_release_Date_Element_Value);
         Assert.assertEquals(Expected_Release_Date, testdata.WIKI_release_Date_Element_Value, " Release date is Not as per expected");
		
	
		String	Expected_Country_Name = obj3.Get_Country_Of_Origen();
		System.out.println("Country of Origin is ::  " +testdata.WIKI_country_Actual_Value);		
	    Assert.assertEquals(Expected_Country_Name, testdata.WIKI_country_Actual_Value, " Country Name is not as per expected");
			
		
	  }
	
	
	@AfterMethod
	public void After_Methord(ITestResult t) 
	
	{
		
		
		if(t.isSuccess())
			
		{
			System.out.println("Execution status of Test: " +t.getMethod().getMethodName() +" is Passed");
			
			driver.close();
			System.out.println("Close Browser:: executed");
		}
		else
		{
			System.out.println("Execution status of Test: " +t.getMethod().getMethodName() +" is Failed");
			
			try {
				// Folder location should be set.
				File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(src, new File ("C:\\Users\\Vijay\\eclipse-workspace\\demo_project1\\SCREENSHOTS" +t.getMethod().getMethodName() +".jpg"));
			    System.out.println("ScreenShot-Captured");
			    
				}
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			driver.close();
			System.out.println("Close Browser:: executed");
			
					
		}
	
	}
	

}
