package com.exigen.shegula.ds_pages;

import net.sourceforge.htmlunit.corejs.javascript.ast.TryStatement;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GuestPage {
	@FindBy(id = "hWrapper")
	private WebElement banner;

	private WebDriver driver;

	private Point location;

	public GuestPage(WebDriver driver) {
		this.driver = driver;
	}

	public String checkBannerLocation() {
		try {
			location = banner.getLocation();
			System.out.println(location.toString());

		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		return location.toString();
	}
}
