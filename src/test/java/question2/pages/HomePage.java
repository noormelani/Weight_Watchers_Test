//1. Navigate to https://www.weightwatchers.com/us/
//2. Verify loaded page title matches “Weight Loss Program, Recipes & Help | Weight Watchers”
//3. On the right corner of the page, click on “Find a Meeting”

package question2.pages;

import question2.base.Page;

public class HomePage extends Page {

	HomePage() {
		// 1. Navigate to https://www.weightwatchers.com/us/
		String url = Config.getProperty("testsiteurl");
		goToPage(url);
	}

	public String getTitle() {
		String home_page_title = pageTitle();
		return home_page_title;
	}

	public MeetingPage findMeeting() {
		// 3. On the right corner of the page, click on “Find a Meeting”
		click("find_meeting");

		return new MeetingPage();

	}

	public static HomePage goToHomePage() {

		return new HomePage();
	}

}
