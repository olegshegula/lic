package com.exigen.shegula;

import org.openqa.selenium.WebDriver;

import com.exigen.shegula.util.Constants;

public class EnterancePage {

	private WebDriver driver;

	public EnterancePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean EnteranceURL() {
		return driver.getCurrentUrl().contains(Constants.EnteranceURL);
	}

}
