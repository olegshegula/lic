package com.exigen.shegula;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.exigen.shegula.util.Constants;

public class InfoProfilePage {
	private WebDriver driver;

	public InfoProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	public String checkEnglLang() {

		return driver.findElement(
				By.xpath(".//*[@id='content']/div/div[2]/p[2]")).getText();

	}

	public boolean checkInfoPupilURL() {
		return driver.getCurrentUrl().contains(
				Constants.inetURL+"/ru/Account/Pupil/Profile");
	}
}
