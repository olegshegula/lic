package com.exigen.shegula.ds_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exigen.shegula.util.PageBase;

public class MyLyceumPage extends PageBase {
	

	public MyLyceumPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "content")
	private WebElement content;

	public boolean isPageOpened() {
		return content.isDisplayed();
	}
}
