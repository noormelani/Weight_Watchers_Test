//Testcases for
//1. Navigate to https://www.weightwatchers.com/us/
//2. Verify loaded page title matches “Weight Loss Program, Recipes & Help | Weight Watchers”
//3. On the right corner of the page, click on “Find a Meeting”

package question2.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import question2.pages.HomePage;

public class HomePageTest {

	@Test(priority = 1)
	public void ValidateHomePageTitle() {
		// Navigate to https://www.weightwatchers.com/us/
		HomePage hp = HomePage.goToHomePage();
		String expectedTitle = "Weight Loss Program, Recipes & Help | Weight Watchers";
		String actualTitle = hp.getTitle();
		// 2. Verify loaded page title matches “Weight Loss Program, Recipes &
		// Help | Weight Watchers”
		Assert.assertEquals(expectedTitle, actualTitle);
	}

}
