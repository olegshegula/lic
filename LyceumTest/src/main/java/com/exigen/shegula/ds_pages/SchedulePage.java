package com.exigen.shegula.ds_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exigen.shegula.util.PageBase;

public class SchedulePage extends PageBase {
	@FindBy(xpath = "//p/a[text()='Edit']")
	private WebElement editLink;

	public SchedulePage(WebDriver driver) {
		super(driver);
	}

	public boolean isPageOpened() {
		return editLink.isDisplayed();
	}

	public void goToEditSchedule() {
		editLink.click();
	}

}
