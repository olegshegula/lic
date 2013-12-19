package com.exigen.shegula.ds_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exigen.shegula.util.PageBase;

public class OlympiadsPage extends PageBase {
	

	
	public OlympiadsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='content']/h2")
	private WebElement header;

	public boolean isPageOpened() {
		if(header.getText().contains("Olympiad")){
			return header.isDisplayed();
		}else
		return false;		
	}
	
}
