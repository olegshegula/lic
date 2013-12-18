package com.exigen.shegula.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base {
	protected WebDriver driver;

	@BeforeMethod()
	@Parameters("browser")
	public void launchBrowser(@Optional("FF") String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/tools/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("FF")) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(Constants.inetURL);
		} else {
			driver = new InternetExplorerDriver();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}

}
