package driverPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager extends DriverManager{

	public WebDriver initChrome()
	{
		WebDriverManager.chromedriver().create();
		return new ChromeDriver();
	}
	
	public WebDriver initChromeHeadless()
	{
		ChromeOptions co = new ChromeOptions();
		co.setHeadless(true);
		
		WebDriverManager.chromedriver().capabilities(co).create();
		return new ChromeDriver(co);
	}
	
	public void launchBrowser(String browser)
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver = initChrome();
			break;
		case "headless":
			driver = initChromeHeadless();
			break;
		default:
			driver = initChrome();
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	
	public void closeBrowser()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
