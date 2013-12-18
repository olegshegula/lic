package com.exigen.shegula;

import org.openqa.selenium.WebDriver;

import com.exigen.shegula.util.Constants;

public class MainPage {
	private WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkURL() {
		if(driver.getCurrentUrl().contains(Constants.inetURL)){
		return true;
		}
		return false;
	}
}
