//Testcases for
//4. Verify loaded page title contains “Get Schedules & Times Near You”
//5. In the search field, search for meetings for zip code: 10011
//6. Print the title of the first result and the distance(located on the right of location title/name)

package question2.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import question2.pages.HomePage;
import question2.pages.MeetingPage;

public class MeetingPageTest {
	public MeetingPage mp = HomePage.goToHomePage().findMeeting();

	@Test(priority = 2)
	public void verifyPageTitle() {
		String actualTitle = HomePage.goToHomePage().findMeeting().getTitle();
		// 4. Verify loaded page title contains “Get Schedules & Times Near You”
		Assert.assertTrue(actualTitle.contains("Get Schedules & Times Near You"));

	}

	@Test(priority = 3)
	public void testAddress() {
		// 5. In the search field, search for meetings for zip code: 10011
		// 6. Print the title of the first result and the distance(located on
		// the right of location title/name)
		mp.searchByZip("10011");

	}

}
