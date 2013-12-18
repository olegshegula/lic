package com.exigen.shegula.ds_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.exigen.shegula.util.PageBase;

public class EditSchedulePage extends PageBase {

	@FindBy(id = "saveScheduleBtn")
	private WebElement saveScheduleBtn;
	@FindBy(id = "message-dialog")
	private WebElement messageDialogText;
	
	public EditSchedulePage(WebDriver driver) {
		super(driver);
	}

	public boolean isPageOpened() {
		return saveScheduleBtn.isDisplayed();
	}

	public void clickSaveBtn() {
		saveScheduleBtn.click();
	}	

}
