package com.exigen.shegula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.exigen.shegula.util.Constants;

public class SchedulePage {
	private WebDriver driver;

	public SchedulePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkScheduleURL() {

		return driver.getCurrentUrl().contains(
				Constants.inetURL + "/ru/Account/Pupil/Schedule");
	}

	public boolean checkTiele() {
		return driver.findElement(
				By.xpath("//h1[contains(@style,'text-align:center')]"))
				.isDisplayed();

	}

	public boolean checkHeader() {
		return driver.findElement(By.xpath("//*[@id='header']")).isDisplayed();
	}

	public boolean checkMenuExist() {
		return driver.findElement(By.xpath(".//*[@id='layout']/div[2]"))
				.isDisplayed();
	}

	public boolean checkPhoto() {
		return driver.findElement(
				By.xpath("//img[contains(@alt,'User avatar')]")).isDisplayed();
	}

	public void checkLinks(String string, String string2, String string3,
			String string4, String string5, String string6, String string7,
			String string8, String string9, String string10) {
		List<String> actualLinkList = new ArrayList<String>();
		List<String> expectedLinkList = Arrays.asList(string, string2, string3,
				string4, string5, string6, string7, string8, string9, string10);

		List<WebElement> linkList = driver.findElements(By.xpath("//a"));
		for (WebElement element : linkList) {
			System.out.println(element.getText());

			actualLinkList.add(element.getText());
		}
		assert actualLinkList.containsAll(expectedLinkList);

	}

}
