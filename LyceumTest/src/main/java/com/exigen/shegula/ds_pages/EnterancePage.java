package com.exigen.shegula.ds_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exigen.shegula.util.PageBase;

public class EnterancePage extends PageBase {
	@FindBy(xpath = "//div[@id='content']/p[1]")
	private WebElement header;

	public EnterancePage(WebDriver driver) {
		super(driver);
	}

	public boolean isPageOpened() {
		if (header.getText().contains("Grants and educational programs notify that .. text")) {
			return header.isDisplayed();
		} else
			return false;
	}
}
