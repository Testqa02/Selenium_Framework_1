


package QA;

import org.openqa.selenium.WebDriver;

public class Object_Repository 


{
	
	
	
	// Element info is set as per its page class data.

String 	IMDB_search_Box_Element = "//input[@id = 'suggestion-search' and @type='text']";

String 	IMDB_list_Item_Element = "(//*[text() ='Pushpa: The Rise - Part 1'])[1]";

String 	IMDB_release_Date = "//a[text() = 'Release date']";

String 	IMDB_release_Date_Element_Value = "(//a[@class = 'ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'])[23]";

String 	IMDB_country_Of_Origen_Value = "(//a[@class = 'ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link' and @role ='button'])[24]";


String 	WIKI_search_Box_Element = "//input[@title ='Search Wikipedia [alt-shift-f]']";

String 	WIKI_list_Item_Element = "(//span[@class = 'cdx-search-result-title'])[1]";

// String 	WIKI_release_Date = "(//*[@class = 'plainlist'])[4]";

String 	WIKI_release_Date_Element_Value = "(//*[@class = 'plainlist'])[4]";

String 	WIKI_country_Of_Origen_Value = "(//*[@class = 'infobox-data'])[12]";

}
