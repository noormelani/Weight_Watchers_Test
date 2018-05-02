//7. Click on the first search result and then, verify displayed location name matches with the name of the first searched result that was clicked.
//8. From this location page, print TODAY’s hours of operation(located towards the bottom of the page)

package question2.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import question2.base.Page;

public class LocationPage extends Page {

	public String getLocationName() {
		// clicking first search result and storing it.
		String search_result = findElement("location_name").getText();
		return search_result;
	}

	public List<String> getTodaysHours() {
		List<String> current_day_and_hours = new ArrayList<String>();
		// From location page finding today
		String today = findElement("today").getText();
		List<WebElement> working_hours_list = findElements("hours");
		// Finding current day hours.
		for (int i = 0; i < working_hours_list.size(); i++) {
			current_day_and_hours.add(working_hours_list.get(i).getText());
		}
		current_day_and_hours.add(today);
		return current_day_and_hours;

	}
}
