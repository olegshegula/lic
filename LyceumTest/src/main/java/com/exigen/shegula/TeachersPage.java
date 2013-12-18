package com.exigen.shegula;

import org.openqa.selenium.WebDriver;

public class TeachersPage {

	private WebDriver driver;

	public TeachersPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkTeacherURL() {
		return driver.getCurrentUrl().contains(Constants.TeacherURL);
	}

}
