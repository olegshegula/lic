package com.exigen.shegula.ds_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
	@FindBy(xpath = "//a[contains(@href,'/en/Authorization/LogOn')]")
	private WebElement logInLink;
	@FindBy(xpath = "//a[text()='English']")
	private WebElement engLink;
	@FindBy(xpath = "//a[text()='Русский']")
	private WebElement rusLink;
	@FindBy(xpath = "//a[text()='Українська']")
	private WebElement ukrLink;

	public void switchLang(int lang) {
		switch (lang) {
		case 1:
			engLink.click();
			break;
		case 2:
			rusLink.click();
			;
			break;
		case 3:
			ukrLink.click();
			break;
		}
	}

	public void logIn() {
		logInLink.click();
	}
}
