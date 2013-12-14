package com.exigen.shegula;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class MainDashboardPage extends Addition{

	private final WebDriver driver;

	public MainDashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public MainDashboardPage FindAndClick(String el, WebDriver driver) {
		driver.findElement(By.xpath(el)).click();
		return new MainDashboardPage(driver);
	}

	public TeachersPage goToPage(String el, WebDriver driver) {
		driver.findElement(By.xpath(el)).click();
		return new TeachersPage(driver);
	}

	public OlymliadsPage goToPageOlymp(String el, WebDriver driver) {
		driver.findElement(By.xpath(el)).click();
		return new OlymliadsPage(driver);
	}

	public String getPupleInfoLink() {
		return driver.findElement(
				By.xpath(".//*[@id='header']/div/table/tbody/tr[1]/th[1]/a"))
				.getText();

	}

	public String getPupleEditLink() {
		return driver.findElement(
				By.xpath(".//*[@id='header']/div/table/tbody/tr[2]/td[1]/a"))
				.getText();
	}

	public String getSignOutLink() {

		return driver.findElement(
				By.xpath(".//*[@id='header']/div/table/tbody/tr[2]/td[2]/a"))
				.getText();
	}

	public String getTmInfo() {

		return driver.findElement(By.xpath(".//*[@id='footer']/p")).getText();
	}

	public String getAboutDevLink() {

		return driver.findElement(By.xpath(".//*[@id='footer']/a[1]"))
				.getText();
	}

	public String getVKLink() {
		return driver.findElement(By.xpath(".//*[@id='footer']/a[2]"))
				.getText();
	}

	public boolean getImagePhoto() {
		return driver.findElement(
				By.xpath("//img[contains(@alt,'User avatar')]")).isDisplayed();

	}

	public boolean checkMenuPanel() {
		return driver.findElement(By.xpath(".//*[@id='layout']/div[2]"))
				.isDisplayed();
	}

	public boolean checkDashboardSchedule() {
		return driver.findElement(
				By.xpath("//div[contains(@onclick,'/ru/Account/Pupil/Schedule')]")).isDisplayed();
	}

	public boolean checkDashboardClassBook() {
		return driver.findElement(
				By.xpath("html/body/div[1]/div[3]/div/div[2]")).isDisplayed();
	}

	public boolean checkDashboardNews() {
		return driver.findElement(
				By.xpath("html/body/div[1]/div[3]/div/div[3]")).isDisplayed();
	}

	public boolean checkDashboardHomework() {
		return driver.findElement(
				By.xpath("html/body/div[1]/div[3]/div/div[4]")).isDisplayed();
	}

	public boolean checkDashboarCircul() {
		return driver.findElement(
				By.xpath("html/body/div[1]/div[3]/div/div[5]")).isDisplayed();
	}

	public boolean getMainHeader() {
		return driver.findElement(By.xpath(".//*[@id='header']/a"))
				.isDisplayed();
	}

	public boolean checkMainDashURL() {
		return driver.getCurrentUrl().contains(Constants.MainDashboardURL);
	}

	public EditProfilePage goToEditPage(String el, WebDriver driver) {
		driver.findElement(By.xpath(el)).click();
		return new EditProfilePage(driver);

	}

	public EnterancePage goToPageEnterance(String el, WebDriver driver) {
		driver.findElement(By.xpath(el)).click();
		return new EnterancePage(driver);
	}

	public ContactsPage goToPageContacts(String el, WebDriver driver) {
		driver.findElement(By.xpath(el)).click();
		return new ContactsPage(driver);
	}

	public void checkMyLyceumSubmenu(String item1, String item2, String item3,
			String item4, String item5) {

		Actions builder = new Actions(driver);
		builder.moveToElement(
				driver.findElement(By.xpath("//a[text()='My Lyceum']")))
				.build().perform();

		List<String> expectedSubmenuList = Arrays.asList(item1, item2, item3,
				item4, item5);
		List<String> actualsSubmenuList = new ArrayList<String>();

		List<WebElement> submenuList = driver.findElements(By
				.xpath("//li[1]//li/a"));

		for (WebElement element : submenuList) {
			System.out.println(element.getText());
			actualsSubmenuList.add(element.getText());

		}
		Assert.assertEquals(actualsSubmenuList, expectedSubmenuList);
		// assert actualsSubmenuList.containsAll(expectedSubmenuList);

	}

	public void checkTeachersSubmenu(String item1, String item2, String item3,
			String item4, String item5) {

		Actions builder = new Actions(driver);
		builder.moveToElement(
				driver.findElement(By.xpath("//a[text()='Teachers']"))).build()
				.perform();

		List<String> expectedSubmenuList = Arrays.asList(item1, item2, item3,
				item4, item5);
		List<String> actualsSubmenuList = new ArrayList<String>();

		List<WebElement> submenuList = driver.findElements(By
				.xpath("//li[2]//li/a"));

		for (WebElement element : submenuList) {
			System.out.println(element.getText());
			actualsSubmenuList.add(element.getText());

		}
		Assert.assertEquals(actualsSubmenuList, expectedSubmenuList);
		// assert actualsSubmenuList.contains(expectedSubmenuList);

	}

	public void checkOlympiadsSubmenu(String item1, String item2, String item3,
			String item4, String item5, String item6, String item7, String item8) {

		Actions builder = new Actions(driver);
		builder.moveToElement(
				driver.findElement(By.xpath("//a[text()='Olympiads']")))
				.build().perform();

		List<String> expectedSubmenuList = Arrays.asList(item1, item2, item3,
				item4, item5, item6, item7, item8);
		List<String> actualsSubmenuList = new ArrayList<String>();

		List<WebElement> submenuList = driver.findElements(By
				.xpath("//li[3]//li/a"));

		for (WebElement element : submenuList) {
			System.out.println(element.getText());
			actualsSubmenuList.add(element.getText());

		}
		Assert.assertEquals(actualsSubmenuList, expectedSubmenuList);
		// assert actualsSubmenuList.contains(expectedSubmenuList);

	}

	public void checkEnteranceSubmenu(String item1, String item2, String item3) {

		Actions builder = new Actions(driver);
		builder.moveToElement(
				driver.findElement(By.xpath("//a[text()='Enterance']")))
				.build().perform();

		List<String> expectedSubmenuList = Arrays.asList(item1, item2, item3);
		List<String> actualsSubmenuList = new ArrayList<String>();

		List<WebElement> submenuList = driver.findElements(By
				.xpath("//li[4]//li/a"));

		for (WebElement element : submenuList) {
			System.out.println(element.getText());
			actualsSubmenuList.add(element.getText());

		}
		Assert.assertEquals(actualsSubmenuList, expectedSubmenuList);
		// assert actualsSubmenuList.contains(expectedSubmenuList);

	}

	public void checkContactsSubmenu(String item1, String item2, String item3) {

		Actions builder = new Actions(driver);
		builder.moveToElement(
				driver.findElement(By.xpath("//a[text()='Contacts']"))).build()
				.perform();

		List<String> expectedSubmenuList = Arrays.asList(item1, item2, item3);
		List<String> actualSubmenuList = new ArrayList<String>();

		List<WebElement> submenuList = driver.findElements(By
				.xpath("//li[5]//li/a"));

		for (WebElement element : submenuList) {
			System.out.println(element.getText());
			actualSubmenuList.add(element.getText());

		}

		Assert.assertEquals(actualSubmenuList, expectedSubmenuList);
		// assert actualsSubmenuList.contains(expectedSubmenuList);

	}

	public boolean checkNameExist() {
		return driver
				.findElement(
						By.xpath("//a[@href='/ru/Account/Pupil/Profile'][@length='0']"))
				.isDisplayed();
	}

	public boolean checkEditExist() {
		return driver
				.findElement(
						By.xpath("//a[contains(@href,'/ru/Account/Pupil/EditPupilProfile')]"))
				.isDisplayed();
	}

	public boolean checkSignOutExist() {
		return driver.findElement(
				By.xpath("//a[contains(@href,'/ru/Authorization/SignOut')]"))
				.isDisplayed();
	}

	public InfoProfilePage goToInfoPage(String el, WebDriver driver) {
		driver.findElement(By.xpath(el)).click();
		return new InfoProfilePage(driver);
	}

	public boolean checkAvatarExist() {
		return driver.findElement(
				By.xpath("//img[contains(@alt,'User avatar')]")).isDisplayed();
	}

	public boolean checkScheduleTitleExist() {

		return driver
				.findElement(
						By.xpath("//div[contains(@onclick,'/ru/Account/Pupil/Schedule')]//h3"))
				.isDisplayed();
	}

	public boolean checkClassBookTitleExist() {
		return driver
				.findElement(
						By.xpath("//div[contains(@onclick,'/ru/Account/ClassBook')]//h3"))
				.isDisplayed();
	}

	public SchedulePage goToSchedulePage() {
		driver.findElement(By.xpath("//div[contains(@onclick,'/ru/Account/Pupil/Schedule')]")).click();
		return new SchedulePage(driver);
	}

	public MainPage SingOut() {
		driver.findElement(By.xpath("//a[contains(@href,'/ru/Authorization/SignOut')]")).click();	
		return new MainPage(driver);
	}

}
