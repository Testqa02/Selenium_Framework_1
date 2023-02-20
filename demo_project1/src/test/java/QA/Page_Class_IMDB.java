package QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Page_Class_IMDB {
	
	
	WebDriver driver;
	Object_Repository objectinfo = new Object_Repository();
	

	
	By search_Box_Element = By.xpath(objectinfo.IMDB_search_Box_Element);
	
	By list_Item_Element = By.xpath(objectinfo.IMDB_list_Item_Element);
	
	By release_Date = By.xpath(objectinfo.IMDB_release_Date);
	
	By release_Date_Element_Value = By.xpath(objectinfo.IMDB_release_Date_Element_Value);
	
	By country_Of_Origen_Value = By.xpath(objectinfo.IMDB_country_Of_Origen_Value);
	
	
	
	// Constructor code
	
	public Page_Class_IMDB(WebDriver driver)
	
	{
		
		this.driver = driver;
		
	}

	public void enter_Text_in_SearchBox(String a)
	
	{
		System.out.println(a);
		driver.findElement(search_Box_Element).sendKeys(a);
	}
	
	
	public void click_on_ListItem()
	
	{
		driver.findElement(list_Item_Element).click();
	}
	
	
	public void Scroll_To_Element()
	
	{
		Actions action = new Actions (driver);
		action.scrollToElement((WebElement) release_Date);
	}
	
public String Get_Release_Date()
	
	{
	return	driver.findElement(release_Date_Element_Value).getText();
	}

public String Get_Country_Of_Origen()

{
return	driver.findElement(country_Of_Origen_Value).getText();
}
	
  }






