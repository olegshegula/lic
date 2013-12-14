package com.exigen.shegula;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditProfilePage {

	private WebDriver driver;

	public EditProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	public EditProfilePage FindAndClick(String el, WebDriver driver) {
		driver.findElement(By.id(el)).click();
		return new EditProfilePage(driver);
	}

	public boolean checkAvarar() {
		return driver.findElement(By.id("avatar-image")).isDisplayed();
	}

	public String checkPupilName() {
		return driver.findElement(By.xpath("//th[1]/a")).getText();

	}

	public InfoProfilePage setLang(String text) {
		final Select selectBox = new Select(driver.findElement(By
				.id("User_MyLanguage")));
		selectBox.selectByVisibleText(text);
		// driver.findElement(By.id("profileSubmit")).click();
		return new InfoProfilePage(driver);
	}

	public InfoProfilePage setSubject(String text) {
		final Select selectBox = new Select(driver.findElement(By
				.id("User_FavouriteSubject")));
		selectBox.selectByVisibleText(text);
		return new InfoProfilePage(driver);
	}

	public void clickAllCheckboxes() {

		WebElement boxes = driver.findElement(By.tagName("input"));
		List<WebElement> chkbox = boxes.findElements(By
				.xpath("//input[@type='checkbox']"));

		for (WebElement element : chkbox) {
			if (!element.isSelected()) {
				element.click();
			}

		}

	}

	public void setOthers(String text) {
		driver.findElement(By.id("OwnInterestInput")).clear();
		driver.findElement(By.id("OwnInterestInput")).sendKeys(text);
	}

	public void setOthers() {
		driver.findElement(By.id("OwnInterestInput")).clear();

	}

	public void setAboutMe(String text) {
		driver.findElement(By.id("User_PersonalInformation")).clear();
		driver.findElement(By.id("User_PersonalInformation")).sendKeys(text);

	}

	public void setAboutMe() {
		driver.findElement(By.id("User_PersonalInformation")).clear();
		;

	}

	public boolean checkOtherInterest() {
		String expected = "My interests:";
		String actual = driver.findElement(
				By.xpath(".//*[@id='content']/div/div[2]/p[5]")).getText();
		if (expected.equals(actual)) {
			return true;
		}
		return false;
	}

	public void uncheckAllCheckboxes() {
		WebElement boxes = driver.findElement(By.tagName("input"));
		List<WebElement> chkbox = boxes.findElements(By
				.xpath("//input[@type='checkbox']"));

		for (WebElement element : chkbox) {
			if (!element.isSelected()) {
				element.click();
			}

		}

		for (WebElement element : chkbox) {
			if (element.isSelected()) {
				element.click();
			}

		}
	}

	public boolean checkAboutMe() {
		String expected = "";
		String actual = driver.findElement(By.id("User_PersonalInformation"))
				.getText();

		if (expected.equals(actual)) {
			return true;
		}
		return false;
	}

	public boolean checkAboutMeFull() {
		String expected = "Some information about Me";
		String actual = driver.findElement(By.id("User_PersonalInformation"))
				.getText();

		if (expected.equals(actual)) {
			return true;
		}
		return false;
	}

	public boolean checkOtherInterestFull() {
		String expected = "My interests: Sport, Music, Computers, Dancing, Swimming";
		String actual = driver.findElement(
				By.xpath(".//*[@id='content']/div/div[2]/p[5]")).getText();
		if (expected.equals(actual)) {
			return true;
		}
		return false;
	}

	public boolean checkPupilURL() {
		return driver.getCurrentUrl().contains(
				Constants.inetURL + "/ru/Account/Pupil/EditPupilProfile");
	}

}
