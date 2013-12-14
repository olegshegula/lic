package com.exigen.shegula;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.exigen.shegula.Constants;

public class LoginPage {

	private final WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public MainDashboardPage goToLogin(String el, WebDriver driver) {

		driver.findElement(By.linkText(el)).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return new MainDashboardPage(driver);

	}

	public MainDashboardPage LogInAction(String login, String pass) {

		driver.findElement(By.id(Constants.LoginById)).sendKeys(login);
		driver.findElement(By.id(Constants.PasswordById)).sendKeys(pass);
		driver.findElement(By.xpath(Constants.EnterByXpath)).submit();
		return new MainDashboardPage(driver);
	}

	public boolean checkRegistrationPanel() {
		return driver.findElement(By.id(".//*[@id='RegistrationPanel']"))
				.isDisplayed();
	}

	public boolean checkEmailLabel() {
		return driver.findElement(
				By.xpath(".//*[@id='RegistrationPanel']/form/div[3]/label"))
				.isDisplayed();
	}

	public boolean checkTitleLabel() {
		return driver.findElement(
				By.xpath(".//*[@id='RegistrationPanel']/form/div[1]"))
				.isDisplayed();
	}

	public boolean checkLoginEdit() {
		return driver.findElement(
				By.id("Login"))
				.isDisplayed();
	}

	public boolean checkPasswordEdit() {
		return driver.findElement(
				By.id("Password"))
				.isDisplayed();
	}

	public boolean checkEnterBtn() {
		return driver.findElement(
				By.xpath(".//*[@id='RegistrationPanel']/form/div[7]/input"))
				.isDisplayed();
	}

	public boolean checkRegLink() {
		return driver.findElement(
				By.linkText("Зарегистрироваться"))
				.isDisplayed();
	}

}
