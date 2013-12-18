package com.exigen.shegula;

import org.openqa.selenium.WebDriver;

public class EnterancePage {

	private WebDriver driver;

	public EnterancePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean EnteranceURL() {
		return driver.getCurrentUrl().contains(Constants.EnteranceURL);
	}

}
