//Testcases for
//7. Click on the first search result and then, verify displayed location name matches with the name of the first searched result that was clicked.
//8. From this location page, print TODAY’s hours of operation(located towards the bottom of the page)

package question2.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import question2.base.Page;
import question2.pages.HomePage;
import question2.pages.LocationPage;

public class LocationPageTest {
	LocationPage lp = HomePage.goToHomePage().findMeeting().searchByZip("10011");

	@Test(priority = 5)
	public void verifyLocationName() {
		String actual_locationname = lp.getLocationName();
		String expected_first_address = HomePage.goToHomePage().findMeeting().getFirstLocation();
		// 7. Click on the first search result and then, verify displayed
		// location name matches with the name of the first searched result that
		// was clicked.
		Assert.assertEquals(expected_first_address, actual_locationname);

	}

	@Test(priority = 4)
	public void testTodayHours() {

		List<String> working_hours = lp.getTodaysHours();
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String today = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime()).toString();
		// 8. From above location page, print TODAY’s hours of operation(located
		// towards the bottom of the page)
		System.out.println(today + "'s working hours are: ");
		for (int i = 0; i < working_hours.size() - 1; i++) {
			System.out.println(working_hours.get(i).toString());
		}

		Assert.assertEquals(working_hours.get(working_hours.size() - 1).toString(), today);

	}

	@AfterTest()
	public void tearDown() {
		Page.driver.close();
	}

}
