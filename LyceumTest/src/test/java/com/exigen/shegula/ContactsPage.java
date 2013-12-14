package com.exigen.shegula;

import org.openqa.selenium.WebDriver;

public class ContactsPage {

	private WebDriver driver;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean ContactsURL() {
		return driver.getCurrentUrl().contains(Constants.ContactsURL);

	}
}
