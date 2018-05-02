
//4. Verify loaded page title contains “Get Schedules & Times Near You”
//5. In the search field, search for meetings for zip code: 10011
//6. Print the title of the first result and the distance(located on the right of location title/name)

package question2.pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import question2.base.Page;

public class MeetingPage extends Page {

	public static String address;
	public String distance;

	public String getTitle() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String meeting_page_title = js.executeScript("return document.title;").toString();
		return meeting_page_title;
	}

	public LocationPage searchByZip(String zip) {
		// In the search field, search for meetings for zip code: 10011
		findElement("meeting_search_box").sendKeys(zip);
		click("search_button");
		List<WebElement> addresses = findElements("addresses_list");
		address = addresses.get(0).getText();
		List<WebElement> distances = findElements("distance_list");
		distance = distances.get(0).getText();
		// Print the title of the first result and the distance
		System.out.println("First Location is: " + address + " and its distance is: " + distance);
		addresses.get(0).click();
		return new LocationPage();
	}

	public String getFirstLocation() {

		return address;
	}

}
