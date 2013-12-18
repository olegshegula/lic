package com.exigen.shegula.ds_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfoProfilePage {
	@FindBy(xpath = ".//*[@id='content']//p[1]")
	private WebElement _TeacherSince;
	@FindBy(xpath = ".//*[@id='content']//p[2]")
	private WebElement _DsSince;
	@FindBy(xpath = ".//*[@id='content']//p[4]")
	private WebElement _Phone;
	
	@FindBy(xpath = "//div[3][@class='personal']")
	private WebElement _Info;

	private WebDriver driver;
	private WebElement element;

	public InfoProfilePage(WebDriver driver) {
		// super(driver);
		this.driver = driver;

	}

	/**
	 * @return the teacherSince
	 */
	public WebElement getTeacherSince() {
		return _TeacherSince;
	}

	/**
	 * @return the dsSince
	 */
	public WebElement getDsSince() {
		return _DsSince;
	}

	/**
	 * @return the phone
	 */
	public WebElement getPhone() {
		return _Phone;
	}

	/**
	 * @return the info
	 */
	public WebElement getInfo() {
		return _Info;
	}

}
