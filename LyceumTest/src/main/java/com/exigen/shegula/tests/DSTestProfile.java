package com.exigen.shegula.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.exigen.shegula.ds_pages.ContactsPage;
import com.exigen.shegula.ds_pages.DirectorInfoPage;
import com.exigen.shegula.ds_pages.EditProfilePage;
import com.exigen.shegula.ds_pages.EditSchedulePage;
import com.exigen.shegula.ds_pages.EnterancePage;
import com.exigen.shegula.ds_pages.GuestPage;
import com.exigen.shegula.ds_pages.InfoProfilePage;
import com.exigen.shegula.ds_pages.LoginPage;
import com.exigen.shegula.ds_pages.MainDashboardPage;
import com.exigen.shegula.ds_pages.MainPage;
import com.exigen.shegula.ds_pages.MyLyceumPage;
import com.exigen.shegula.ds_pages.OlympiadsPage;
import com.exigen.shegula.ds_pages.SchedulePage;
import com.exigen.shegula.ds_pages.TeachersPage;
import com.exigen.shegula.util.Base;
import com.exigen.shegula.util.Constants;
import com.exigen.shegula.util.PageBase;

public class DSTestProfile extends Base {
	@Test
	public void testAuthentication() {

		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.switchLang(1);
		mainPage.logIn();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(loginPage.isPageOpened());
		loginPage.login();
		MainDashboardPage main = PageFactory.initElements(driver,
				MainDashboardPage.class);
		main.isTextPresent("Серебрянська Ольга Миколаївна");
	}

	@Test
	public void testSetProfilePositiv() {

		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.switchLang(1);
		mainPage.logIn();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(loginPage.isPageOpened());
		loginPage.login();
		MainDashboardPage main = PageFactory.initElements(driver,
				MainDashboardPage.class);
		main.isTextPresent("Серебрянська Ольга Миколаївна");
		main.editClick();
		EditProfilePage editPage = PageFactory.initElements(driver,
				EditProfilePage.class);
		editPage.isPageOpened();

		editPage.setTeacherSince("1990");
		editPage.setDsSince("1995");
		editPage.setPhone("0689687411");
		editPage.setLang("English");
		editPage.setInfo("Some info...");
		// "Image successfully saved."
		editPage.uploadPhoto();
		editPage.submit();

		editPage.goToInfo();

		InfoProfilePage infoPage = PageFactory.initElements(driver,
				InfoProfilePage.class);
		System.out.println(infoPage.getTeacherSince().getText());

		Assert.assertEquals(infoPage.getTeacherSince().getText(),
				"Have been teaching since: 1990");
		Assert.assertEquals(infoPage.getDsSince().getText(), "DS since: 1995");
		Assert.assertEquals(infoPage.getPhone().getText(),
				"Contact phone: 0689687411");
		Assert.assertEquals(infoPage.getInfo().getText(), "Some info...");
	}

	@Test
	public void testSaveSchedule() {

		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.switchLang(1);
		mainPage.logIn();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(loginPage.isPageOpened());
		loginPage.login();
		MainDashboardPage main = PageFactory.initElements(driver,
				MainDashboardPage.class);
		main.isTextPresent("Серебрянська Ольга Миколаївна");
		main.goToSchecule();
		SchedulePage schedule = PageFactory.initElements(driver,
				SchedulePage.class);

		Assert.assertTrue(schedule.isPageOpened());
		schedule.goToEditSchedule();
		EditSchedulePage edschedule = PageFactory.initElements(driver,
				EditSchedulePage.class);
		edschedule.isPageOpened();
		PageBase.waitForElementPresent(driver, By.id("saveScheduleBtn"), 15);
		edschedule.clickSaveBtn();
		PageBase.waitForElementPresent(driver, By.id("message-dialog"), 15);

	}

	@Test
	public void testCheckWrapper() {

		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.switchLang(1);
		mainPage.logIn();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(loginPage.isPageOpened());
		loginPage.login();
		MainDashboardPage main = PageFactory.initElements(driver,
				MainDashboardPage.class);
		main.isTextPresent("Серебрянська Ольга Миколаївна");
		Assert.assertEquals(main.checkWrapperLocation(), "(292, 662)");
		Assert.assertEquals(main.checkBannerLocation(), "Error");

	}

	@Test
	public void testCheckWrapperDirector() {

		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.switchLang(1);
		mainPage.logIn();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(loginPage.isPageOpened());
		loginPage.login();
		MainDashboardPage main = PageFactory.initElements(driver,
				MainDashboardPage.class);
		main.isTextPresent("Серебрянська Ольга Миколаївна");
		main.open("http://178.215.169.205:8081/en/Account/Account/ViewProfile/8");
		DirectorInfoPage dirInfo = PageFactory.initElements(driver,
				DirectorInfoPage.class);
		Assert.assertFalse(dirInfo.checkBannerLocation());

	}

	@Test
	public void testCheckWrapperGuestPage() {

		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.switchLang(1);
		mainPage.logIn();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(loginPage.isPageOpened());
		loginPage.login();
		MainDashboardPage main = PageFactory.initElements(driver,
				MainDashboardPage.class);
		main.isTextPresent("Серебрянська Ольга Миколаївна");
		main.open(Constants.inetURL);
		GuestPage dirInfo = PageFactory.initElements(driver, GuestPage.class);
		dirInfo.checkBannerLocation();
		Assert.assertEquals(dirInfo.checkBannerLocation(), "(292, 662)");
	}

	@Test
	public void testCheckWrapperEditDSPage() {
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.switchLang(1);
		mainPage.logIn();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(loginPage.isPageOpened());
		loginPage.login();
		MainDashboardPage main = PageFactory.initElements(driver,
				MainDashboardPage.class);
		main.isTextPresent("Серебрянська Ольга Миколаївна");
		main.editClick();
		EditProfilePage editPage = PageFactory.initElements(driver,
				EditProfilePage.class);
		editPage.isPageOpened();
		Assert.assertEquals(editPage.checkWrapperLocation(), "(283, 727)");

	}

	@Test
	public void testSignOut() {

		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.switchLang(1);
		mainPage.logIn();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(loginPage.isPageOpened());
		loginPage.login();
		MainDashboardPage main = PageFactory.initElements(driver,
				MainDashboardPage.class);
		main.isTextPresent("Серебрянська Ольга Миколаївна");
		Assert.assertTrue(main.isPageOpened());
		main.singOut();

	}

	@Test
	public void testHeader() {

		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.switchLang(1);
		mainPage.logIn();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(loginPage.isPageOpened());
		loginPage.login();
		MainDashboardPage main = PageFactory.initElements(driver,
				MainDashboardPage.class);
		main.isTextPresent("Серебрянська Ольга Миколаївна");
		Assert.assertTrue(main.isPageOpened());
		Assert.assertTrue(main.isHeaderExist());

	}

	@Test
	public void testMainMenuClick() {

		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.switchLang(1);
		mainPage.logIn();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(loginPage.isPageOpened());
		loginPage.login();
		MainDashboardPage main = PageFactory.initElements(driver,
				MainDashboardPage.class);
		Assert.assertTrue(main.isPageOpened());
		Assert.assertTrue(main.isTextPresent("Серебрянська Ольга Миколаївна"));
		Assert.assertTrue(main.isTextPresent("Edit"));
		Assert.assertTrue(main.isTextPresent("Sign out"));
		Assert.assertTrue(main.isTextPresent("Exigen Agile Practice (c)"));
		Assert.assertTrue(main.isTextPresent("Developers page"));
		Assert.assertTrue(main.isTextPresent("VK - group"));
		Assert.assertTrue(main.isTextPresent("My Lyceum"));
		Assert.assertTrue(main.isTextPresent("Teachers"));
		Assert.assertTrue(main.isTextPresent("Olympiads"));
		Assert.assertTrue(main.isTextPresent("Enterance"));
		Assert.assertTrue(main.isTextPresent("Contacts"));
		Assert.assertTrue(main.isHeaderExist());

		main.clickOnMenu(1);

		MyLyceumPage myLyc = PageFactory.initElements(driver,
				MyLyceumPage.class);
		Assert.assertTrue(myLyc.isPageOpened());
		Assert.assertTrue(myLyc.isTextPresent("Серебрянська Ольга Миколаївна"));

		main.clickOnMenu(2);
		TeachersPage teachers = PageFactory.initElements(driver,
				TeachersPage.class);

		Assert.assertTrue(teachers.isPageOpened());
		Assert.assertTrue(teachers
				.isTextPresent("Серебрянська Ольга Миколаївна"));

		main.clickOnMenu(3);

		OlympiadsPage olympPage = PageFactory.initElements(driver,
				OlympiadsPage.class);
		Assert.assertTrue(olympPage.isPageOpened());
		Assert.assertTrue(olympPage
				.isTextPresent("Серебрянська Ольга Миколаївна"));

		main.clickOnMenu(4);

		EnterancePage enterancePage = PageFactory.initElements(driver,
				EnterancePage.class);
		Assert.assertTrue(enterancePage.isPageOpened());
		Assert.assertTrue(enterancePage
				.isTextPresent("Серебрянська Ольга Миколаївна"));

		main.clickOnMenu(5);

		ContactsPage contPage = PageFactory.initElements(driver,
				ContactsPage.class);
		Assert.assertTrue(contPage.isPageOpened());
		Assert.assertTrue(contPage
				.isTextPresent("Серебрянська Ольга Миколаївна"));

	}

	@Test
	public void testFillSchedule8AMonday() {

		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.switchLang(1);
		mainPage.logIn();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(loginPage.isPageOpened());
		loginPage.login();
		MainDashboardPage main = PageFactory.initElements(driver,
				MainDashboardPage.class);
		main.isTextPresent("Серебрянська Ольга Миколаївна");
		main.goToSchecule();
		SchedulePage schedule = PageFactory.initElements(driver,
				SchedulePage.class);

		Assert.assertTrue(schedule.isPageOpened());
		schedule.goToEditSchedule();
		EditSchedulePage edschedule = PageFactory.initElements(driver,
				EditSchedulePage.class);
		edschedule.isPageOpened();

		edschedule.setFirstSubject("Математика");
		edschedule.setFirstTeacher("Ургант Іван");
		edschedule.setFirstLessClass("25");

		edschedule.setSecondSubject("Програмування");
		edschedule.setSecondTeacher("Федорів Іван");
		edschedule.setSecondLessClass("65");

		edschedule.setThirdSubject("Англійська");
		edschedule.setThirdTeacher("Сагайдачний Петро");
		edschedule.setThirdLessClass("101");

		edschedule.setForthSubject("Історія");
		edschedule.setForthTeacher("Поляков Олег Володимирович");
		edschedule.setForthLessClass("145");

		edschedule.clickSaveBtn();
	}
}
