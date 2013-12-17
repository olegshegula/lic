package com.exigen.shegula;

import org.openqa.selenium.WebDriver;

import com.exigen.shegula.util.Constants;

public class TeachersPage {

	private WebDriver driver;

	public TeachersPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkTeacherURL() {
		return driver.getCurrentUrl().contains(Constants.TeacherURL);
	}

}
