package com.exigen.shegula.ds_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exigen.shegula.util.PageBase;

public class TeachersPage extends PageBase{


	public TeachersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2")
	private WebElement header;

	public boolean isPageOpened() {
		return header.isDisplayed();
	}
}
