package browserConfig;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBaseDriver {
	
	public WebDriver driver;
	String nabUrl="https://nab.com.au";
	
	
	//String browser = "chrome";
	
	public void init() {
		selectBrowser("chrome");
		getUrl(nabUrl);
	}
	
	public void init(String browser) {
		selectBrowser(browser);
		getUrl(nabUrl);
	}
	
	public void init(String browser, String url)
	{
		selectBrowser(browser);
		getUrl(url);
	}
	
	
	public void selectBrowser(String browser)
	{
		if (browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			// Create a new instance of the Firefox driver/
			driver = new ChromeDriver();
		}
	
	}
	public void getUrl(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}
