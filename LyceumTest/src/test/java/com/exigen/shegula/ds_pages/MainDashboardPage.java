package com.exigen.shegula.ds_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exigen.shegula.util.PageBase;

public class MainDashboardPage extends PageBase {

	@FindBy(xpath = "//a[contains(@href,'/en/Authorization/SignOut')]")
	private WebElement singOut;
	@FindBy(xpath = "//a[@href='/en/Account/Account/EditProfile']")
	private WebElement editLink;
	@FindBy(xpath = "//div[contains(@onclick,'/en/Account/DirectorOfStudies/CommonSchedule')]")
	private WebElement scheduleLink;
	@FindBy(id = "hWrapper")
	private WebElement hWrapper;
	@FindBy(xpath = ".//*[@id='carouselh']/div[7]")
	private WebElement banner;
	@FindBy(id = "header")
	private WebElement header;

	@FindBy(xpath = "//a[@href='/en/Account/DirectorOfStudies/Dashboard']")
	private WebElement MyLyceum;
	@FindBy(xpath = "//a[@href='/en/Teacher']")
	private WebElement Teachers;
	
	@FindBy(xpath = "//a[@href='/en/Olympiad']")
	private WebElement Olympiads;
	
	@FindBy(xpath = "//a[@href='/en/Enterance']")
	private WebElement Enterance;
	
	@FindBy(xpath = "//a[@href='/en/Contacts']")
	private WebElement Contacts;

	private WebDriver driver;
	private Point location;
	private Point sonar;

	public MainDashboardPage(WebDriver driver) {
		super(driver);
	}

	public void singOut() {
		singOut.click();

	}

	public void editClick() {
		editLink.click();
	}

	public boolean isPageOpened() {
		return singOut.isDisplayed();

	}

	public boolean isHeaderExist() {
		return header.isDisplayed();

	}

	// public void goToPage(String address) {
	// banner.get(address);
	// }

	public void goToSchecule() {
		scheduleLink.click();
	}

	public String checkWrapperLocation() {
		try {
			location = hWrapper.getLocation();
			System.out.println(location.toString());

		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		return location.toString();
	}

	public String checkBannerLocation() {
		try {
			sonar = banner.getLocation();
			System.out.println(sonar.toString());

		} catch (Exception e) {
			System.out.println("Error " + e);
			return ("Error");
		}
		return sonar.toString();

	}
/*
	public void clickOnMenu(String text) {
		switch (text) {
		case "MyLyceum":
			MyLyceum.click();
			break;
		case "Teachers":
			Teachers.click();

			break;
		case "Olympiads":
			Olympiads.click();
			break;

		case "Enterance":
			Enterance.click();
			break;
		case "Contacts":
			Contacts.click();
			break;
		}
	}
*/
}
