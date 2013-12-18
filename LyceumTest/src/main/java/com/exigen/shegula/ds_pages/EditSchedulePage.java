package com.exigen.shegula.ds_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.exigen.shegula.util.PageBase;

public class EditSchedulePage extends PageBase {

	@FindBy(id = "saveScheduleBtn")
	private WebElement saveScheduleBtn;
	@FindBy(id = "message-dialog")
	private WebElement messageDialogText;

	@FindBy(xpath = ".//*[@id='firstTr']/div/div[1]/div[1]/div[1]")
	private WebElement el;

	@FindBy(xpath = ".//*[@id='firstTr']/div/div[2]/div[1]/div[1]")
	private WebElement el2;

	@FindBy(xpath = ".//*[@id='firstTr']/div/div[3]/div[1]/div[1]")
	private WebElement el3;

	@FindBy(xpath = ".//*[@id='firstTr']/div/div[4]/div[1]/div[1]")
	private WebElement el4;

	@FindBy(id = "DailyShedules_0__Classes_0__Lessons_0__Subject_SubjectId")
	private WebElement firstSubject;

	@FindBy(id = "DailyShedules_0__Classes_0__Lessons_1__Subject_SubjectId")
	private WebElement secondSubject;

	@FindBy(id = "DailyShedules_0__Classes_0__Lessons_2__Subject_SubjectId")
	private WebElement thirdSubject;

	@FindBy(id = "DailyShedules_0__Classes_0__Lessons_3__Subject_SubjectId")
	private WebElement forthSubject;

	@FindBy(xpath = ".//*[@id='firstTr']/div/div[1]/div[1]/div[2]")
	private WebElement selectTeacher1;

	@FindBy(xpath = ".//*[@id='firstTr']/div/div[2]/div[1]/div[2]")
	private WebElement selectTeacher2;

	@FindBy(xpath = ".//*[@id='firstTr']/div/div[3]/div[1]/div[2]")
	private WebElement selectTeacher3;

	@FindBy(xpath = ".//*[@id='firstTr']/div/div[4]/div[1]/div[2]")
	private WebElement selectTeacher4;

	@FindBy(id = "DailyShedules_0__Classes_0__Lessons_0__Teacher_UserId")
	private WebElement firstTeacher;

	@FindBy(id = "DailyShedules_0__Classes_0__Lessons_1__Teacher_UserId")
	private WebElement secondTeacher;

	@FindBy(id = "DailyShedules_0__Classes_0__Lessons_2__Teacher_UserId")
	private WebElement thirdTeacher;

	@FindBy(id = "DailyShedules_0__Classes_0__Lessons_3__Teacher_UserId")
	private WebElement forthTeacher;

	@FindBy(id = "DailyShedules_0__Classes_0__Lessons_0__ClassRoom")
	private WebElement class1;

	@FindBy(id = "DailyShedules_0__Classes_0__Lessons_1__ClassRoom")
	private WebElement class2;

	@FindBy(id = "DailyShedules_0__Classes_0__Lessons_2__ClassRoom")
	private WebElement class3;

	@FindBy(id = "DailyShedules_0__Classes_0__Lessons_3__ClassRoom")
	private WebElement class4;

	public EditSchedulePage(WebDriver driver) {
		super(driver);
	}

	public boolean isPageOpened() {
		return saveScheduleBtn.isDisplayed();
	}

	public void clickSaveBtn() {
		saveScheduleBtn.click();
	}

	public void setFirstSubject(String text) {
		Actions builder = new Actions(driver);
		builder.doubleClick(el).build().perform();

		final Select selectBox = new Select(firstSubject);
		selectBox.selectByVisibleText(text);

	}

	public void setSecondSubject(String text) {
		Actions builder = new Actions(driver);
		builder.doubleClick(el2).build().perform();

		final Select selectBox = new Select(secondSubject);
		selectBox.selectByVisibleText(text);

	}

	public void setThirdSubject(String text) {
		Actions builder = new Actions(driver);
		builder.doubleClick(el3).build().perform();

		final Select selectBox = new Select(thirdSubject);
		selectBox.selectByVisibleText(text);
	}

	public void setForthSubject(String text) {
		Actions builder = new Actions(driver);
		builder.doubleClick(el4).build().perform();

		final Select selectBox = new Select(forthSubject);
		selectBox.selectByVisibleText(text);
	}

	public void setFirstTeacher(String text) {
		Actions builder = new Actions(driver);
		builder.doubleClick(selectTeacher1).build().perform();

		final Select selectBox = new Select(firstTeacher);
		selectBox.selectByVisibleText(text);
	}

	public void setSecondTeacher(String text) {
		Actions builder = new Actions(driver);
		builder.doubleClick(selectTeacher2).build().perform();

		final Select selectBox = new Select(secondTeacher);
		selectBox.selectByVisibleText(text);
	}

	public void setThirdTeacher(String text) {
		Actions builder = new Actions(driver);
		builder.doubleClick(selectTeacher3).build().perform();

		final Select selectBox = new Select(thirdTeacher);
		selectBox.selectByVisibleText(text);
	}

	public void setForthTeacher(String text) {
		Actions builder = new Actions(driver);
		builder.doubleClick(selectTeacher4).build().perform();

		final Select selectBox = new Select(forthTeacher);
		selectBox.selectByVisibleText(text);
	}

	public void setFirstLessClass(String num) {
		class1.clear();
		class1.sendKeys(num);
	}

	public void setSecondLessClass(String num) {
		class2.clear();
		class2.sendKeys(num);
	}

	public void setThirdLessClass(String num) {
		class3.clear();
		class3.sendKeys(num);
	}

	public void setForthLessClass(String num) {
		class4.clear();
		class4.sendKeys(num);
	}
}
