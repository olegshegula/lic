package com.exigen.shegula.ds_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exigen.shegula.util.PageBase;

public class TeachersPage extends PageBase{


	public TeachersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2")
	private WebElement header;
	
	@FindBy(xpath = "//a[@href='/en/Olympiad']")
	private WebElement Olympiads;

	public boolean isPageOpened() {
		return header.isDisplayed();
	}
	
	public void goToOlymp(){
		System.out.println("clecked");
		Olympiads.click();
	}
}
