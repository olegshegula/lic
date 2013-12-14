package com.exigen.shegula;

import org.openqa.selenium.WebDriver;


public class OlymliadsPage {
	private WebDriver driver;

	public OlymliadsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean OlymliadsURL() {
		return driver.getCurrentUrl().contains(Constants.OlymliadsURL);
	}

}
