package com.exigen.shegula.ds_pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.exigen.shegula.util.PageBase;

public class EditProfilePage {
	@FindBy(id = "TeacherSince")
	private WebElement TeacherSince;
	@FindBy(id = "DsSince")
	private WebElement DsSince;
	@FindBy(id = "Phone")
	private WebElement Phone;
	@FindBy(id = "MyLanguage")
	private WebElement MyLanguage;
	@FindBy(id = "Info")
	private WebElement Info;
	@FindBy(xpath = ".//input[@name='file']")
	private WebElement uploadPhoto;
	@FindBy(id = "profileSubmit")
	private WebElement profileSubmit;
	
	@FindBy(id = "hWrapper")
	private WebElement hWrapper;

	private WebDriver driver;
	private WebElement element;
	private Object location;

	public EditProfilePage(WebDriver driver) {
		// super(driver);
		this.driver = driver;

	}

	public void setTeacherSince(String text) {
		TeacherSince.clear();
		TeacherSince.sendKeys(text);
	}

	public void setDsSince(String text) {
		DsSince.clear();
		DsSince.sendKeys(text);
	}

	public void setPhone(String text) {
		Phone.clear();
		Phone.sendKeys(text);
	}

	public void setLang(String text) {
		final Select selectBox = new Select(MyLanguage);
		selectBox.selectByVisibleText(text);
	}

	public void setInfo(String text) {
		Info.clear();
		Info.sendKeys(text);
	}

	public void goToInfo() {
		driver.get("http://178.215.169.205:8081/ru/Account/DirectorOfStudies/Profile");
	}

	public void submit() {
		profileSubmit.click();
	}

	public void uploadPhoto() {
		String parentWindowId = driver.getWindowHandle();
		try {
			element = driver.findElement(By.xpath("//input[@type='file']"));
			element.sendKeys("c:\\teacher.jpg");
			// element.sendKeys("c:\\maint.jpg");

		} catch (Exception e) {
			System.out.println("can't upload the file " + e);

		}

		Set<String> allWindows = driver.getWindowHandles();
		if (!allWindows.isEmpty()) {
			for (String windowId : allWindows) {
				System.out.println(windowId);
				driver.switchTo().window(windowId);
				String s = driver.switchTo().window(windowId).getTitle();
				System.out.println(s);
				if (driver.getPageSource()
						.contains("Image successfully saved.")) {
					try {
						boolean header = driver
								.findElement(By.id("popup_title")).getText()
								.contains("Information");
						System.out.println(header);
						WebElement OkButton = driver.findElement(By
								.id("popup_ok"));
						OkButton.click();
						break;
					} catch (NoSuchWindowException e) {
						e.printStackTrace();
					}
				}
			}

			driver.switchTo().window(parentWindowId);

		}

	}

	public String checkWrapperLocation() {
		try {
			location = hWrapper.getLocation();
			System.out.println(location.toString());

		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		return location.toString();
	}

	public boolean isPageOpened() {
		return TeacherSince.isDisplayed();

	}
}
