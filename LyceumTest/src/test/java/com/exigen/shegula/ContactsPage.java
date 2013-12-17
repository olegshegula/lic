package com.exigen.shegula;

import org.openqa.selenium.WebDriver;

import com.exigen.shegula.util.Constants;

public class ContactsPage {

	private WebDriver driver;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean ContactsURL() {
		return driver.getCurrentUrl().contains(Constants.ContactsURL);

	}
}
