package com.exigen.shegula;

import org.openqa.selenium.WebDriver;

import com.exigen.shegula.util.Constants;


public class OlymliadsPage {
	private WebDriver driver;

	public OlymliadsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean OlymliadsURL() {
		return driver.getCurrentUrl().contains(Constants.OlymliadsURL);
	}

}
