package question2.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	public static WebDriver driver;

	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static FileInputStream fis;
	public static WebDriverWait wait;

	public Page() {

		/*
		 * if(driver==null){ System.setProperty("webdriver.chrome.driver",
		 * System.getProperty("user.dir") +
		 * "\\src\\test\\resources\\executables\\chromedriver.exe"); driver =
		 * new ChromeDriver(); driver.get("https://www.weightwatchers.com/us/");
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 */

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (Config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (Config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (Config.getProperty("browser").equals("ie")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}

			driver.get(Config.getProperty("testsiteurl"));

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

			wait = new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicit.wait")));

		}

	}

	public void click(String locator) {

		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();

	}

	public void type(String locator, String value) {

		driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
	}

	public WebElement findElement(String locator) {
		return driver.findElement(By.cssSelector(OR.getProperty(locator)));

	}

	public List<WebElement> findElements(String locator) {

		return driver.findElements(By.cssSelector(OR.getProperty(locator)));
	}

	public String pageTitle() {
		return driver.getTitle();
	}

	public void goToPage(String locator) {

		driver.get(locator);

	}

}
