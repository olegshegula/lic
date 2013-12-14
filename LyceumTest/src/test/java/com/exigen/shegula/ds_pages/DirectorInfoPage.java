package com.exigen.shegula.ds_pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectorInfoPage {
	@FindBy(xpath = ".//*[@id='carouselh']/div[7]")
	private WebElement banner;

	private WebDriver driver;

	public DirectorInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkBannerLocation() {
		return banner.isDisplayed();
	}

}
