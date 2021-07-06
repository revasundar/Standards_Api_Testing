package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebElementActions {
	WebDriver driver;
	
	public WebElementActions(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickAction(String webLocator)
	{
		try {
			driver.findElement(By.xpath(webLocator)).click();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void clickByName(String elementName)
	{
		try {
			((JavascriptExecutor)driver).executeScript("window.focus();");
			//new Actions(driver).moveToElement(elementName).click().perform();
			driver.findElement(By.name(elementName)).click();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void clickByText(String locator, String text)
	{
		try {
			WebElement we = driver.findElement(By.xpath(locator));
			if (we.getText() == "Next")
			{
				we.click();
				Thread.sleep(1000);
			}
		}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
	}
	
	public void clickActionPerform(String webLocator)
	{
		try {
			WebElement we = driver.findElement(By.xpath(webLocator));
			Actions clickAction = new Actions(driver).click(we);
			clickAction.build().perform();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	
	
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void navigatesTo(String url)
	{
		driver.navigate().to(url);
	}
	
	public void enterInput(String locator, String inputData)
	{
		
		//driver.findElement(By.xpath("locator")).sendKeys(inputData);
		System.out.println("xpath Locator: "+locator+" "+inputData);
		WebElement element = driver.findElement(By.xpath("locator"));
		element.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//element.clear();
		//element.sendKeys(inputData);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value= inputData;", element);
	}
	

}
