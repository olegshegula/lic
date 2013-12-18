/**
 * 
 */
package com.exigen.shegula;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author shcegula-os
 * 
 */
public class Addition {

	private WebDriver driver;

	public boolean isElementPresent(String el, WebDriver driver) {

		try {
			Assert.assertTrue(driver.getPageSource().contains(el));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e + "Error");
			return false;
		}
	}

	/*
	 * public static boolean isTextPresent(String text) { try{ return
	 * driver.findElement(By.tagName("body")).getText().contains(text); } catch
	 * (NoSuchElementException e) { return false;
	 * 
	 * }
	 * 
	 * public void assertSoft(boolean success, String message, StringBuilder
	 * messages) { if (!success) messages.append(message); }
	 * 
	 * public void assertSoftFalse(boolean success, String message,
	 * StringBuilder messages) { if (success) messages.append(message); }
	 * 
	 * public void assertEmpty(StringBuilder sb) { if (sb.length() &gt; 0) {
	 * throw new AssertionError(sb.toString()); } }
	 */

	public WebElement findXpath(String xp) {
		return driver.findElement(By.xpath(xp));
	}

	public WebElement findId(String id) {
		return driver.findElement(By.id(id));
	}

	public WebElement findLink(String link) {
		return driver.findElement(By.linkText(link));
	}

	

}
