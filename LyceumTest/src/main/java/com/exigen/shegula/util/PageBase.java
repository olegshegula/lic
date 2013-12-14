package com.exigen.shegula.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object base class. It provides the base structure and properties for a
 * page object to extend.
 * 
 * @author
 */
public class PageBase {

	public static final int DEFAULT_WAIT_4_ELEMENT = 7;
	public static final int DEFAULT_WAIT_4_PAGE = 12;
	/** Default URL */
	// protected String URL;

	/** This page's WebDriver */
	public WebDriver driver;

	/**
	 * Expected Page Title. This will be used in isPageLoad() to check if page
	 * is loaded.
	 */
	// protected String pageTitle;

	/** Constructor */
	public PageBase(WebDriver driver) {
		this.driver = driver;
		// this.pageTitle = pageTitle;
	}

	/**
	 * Check if page is loaded by comparing the expected page-title with an
	 * actual page-title.
	 **/
	// public boolean isPageLoad() {
	// return (driver.getTitle().contains(pageTitle));
	// }

	/** Open the default page */
	public void open(String URL) {
		driver.get(URL);
	}

	/** Returns the page title */
	// public String getTitle() {
	// return pageTitle;
	// }

	/** Returns the default URL */
	// public String getURL() {
	// return URL;
	// }

	/**
	 * Send text keys to the element that finds by xpathExpression. It shortens
	 * "driver.findElement(By.cssSelector()).sendKeys()".
	 * 
	 * @param cssSelector
	 * @param text
	 */
	protected void sendText(String xpathExpression, String text) {
		driver.findElement(By.xpath(xpathExpression)).sendKeys(text);
	}

	/** Is the text present in page. */
	public boolean isTextPresent(String text) {

		return driver.getPageSource().contains(text);

	}	
	
	/** Is the Element in page. */
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);// if it does not find the element throw
									// NoSuchElementException, thus returns
									// false.
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Is the Element present in the DOM.
	 * 
	 * @param _xpathExpression
	 *            element locater
	 * @return WebElement
	 */
	public boolean isElementPresent(String _xpathExpression) {
		try {
			driver.findElement(By.xpath(_xpathExpression));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Checks if the elment is in the DOM and displayed.
	 * 
	 * @param by
	 *            - selector to find the element
	 * @return true or false
	 */
	public boolean isElementPresentAndDisplay(By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Returns the first WebElement using the given method. It shortens
	 * "driver.findElement(By)".
	 * 
	 * @param by
	 *            element locater.
	 * @return the first WebElement
	 */
	public WebElement getWebElement(By by) {
		return driver.findElement(by);
	}

	public static WebElement waitForElementPresent(WebDriver driver,

	final By by, int timeOutInSeconds) {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions
					.presenceOfElementLocated(by));

			driver.manage().timeouts()
					.implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																			// implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
