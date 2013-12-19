package com.exigen.shegula.ds_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exigen.shegula.util.PageBase;

public class ContactsPage extends PageBase {
	@FindBy(xpath = "//div[@id='content']/h2")
	private WebElement header;

	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	public boolean isPageOpened() {
		if (header.getText().contains("How to find us?")) {
			return header.isDisplayed();
		} else
			return false;
	}
}
