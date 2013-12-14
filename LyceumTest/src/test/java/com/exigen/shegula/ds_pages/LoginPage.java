package com.exigen.shegula.ds_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exigen.shegula.util.PageBase;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// @FindBy(className = "btn")
	@FindBy(xpath = "//input[contains(@type,'submit')]")
	private WebElement submit;

	public boolean isPageOpened() {
		return submit.isDisplayed();

	}

	public void login() {

		driver.findElement(By.id("Login")).sendKeys("testDirector1@mail.ru");
		driver.findElement(By.id("Password")).sendKeys("12345");
		submit.click();
	}

}
