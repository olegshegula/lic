/**
 * 
 */
package com.exigen.shegula.tests;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.exigen.shegula.Constants;
import com.exigen.shegula.ContactsPage;
import com.exigen.shegula.EditProfilePage;
import com.exigen.shegula.EnterancePage;
import com.exigen.shegula.InfoProfilePage;
import com.exigen.shegula.LoginPage;
import com.exigen.shegula.MainDashboardPage;
import com.exigen.shegula.MainPage;
import com.exigen.shegula.OlymliadsPage;
import com.exigen.shegula.SchedulePage;
import com.exigen.shegula.TeachersPage;
import com.exigen.shegula.util.Base;

/**
 * @author shcegula-os
 * 
 */
public class LyceumTestProfile extends Base {

	@Test
	public void testAuthenticationPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		
		Assert.assertTrue(loginPage.checkEmailLabel());
		Assert.assertTrue(loginPage.checkTitleLabel());
		Assert.assertTrue(loginPage.checkLoginEdit());
		Assert.assertTrue(loginPage.checkPasswordEdit());
		Assert.assertTrue(loginPage.checkEnterBtn());
		Assert.assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		Assert.assertTrue(dashboard.getImagePhoto());

	}
	@Test
	public void testSignOutPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		
		Assert.assertTrue(loginPage.checkEmailLabel());
		Assert.assertTrue(loginPage.checkTitleLabel());
		Assert.assertTrue(loginPage.checkLoginEdit());
		Assert.assertTrue(loginPage.checkPasswordEdit());
		Assert.assertTrue(loginPage.checkEnterBtn());
		Assert.assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin2, Constants.PupilPassword);
		Assert.assertTrue(dashboard.getImagePhoto());
		MainPage main =  dashboard.SingOut();
		Assert.assertTrue(main.checkURL());

	}
/*
	// US#34 test 34.8.3
	@Test
	public void testSetEngLang() {
		// //////////////////////////////////////////////////////////
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		assertTrue(dashboard.getImagePhoto());
		// /////////////////////////////////////////////////////////
		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);

		assertTrue(editprof.checkAvarar());
		assertTrue(editprof.checkPupilName().contains("Іванов Микита"));
		InfoProfilePage infoprof = editprof.setLang("English");
		editprof.FindAndClick(Constants.SaveByID, driver);
		assertTrue(infoprof.checkEnglLang().contains(
				"Year of entering: 2013 - 2014"));

	}
	// US#34 test 34.8.3
		@Test
		public void testSetEngLang2() {
			// //////////////////////////////////////////////////////////
			driver.get(Constants.inetURL);
			LoginPage loginPage = new LoginPage(driver);

			MainDashboardPage lpage = loginPage.goToLogin(
					Constants.EnterByLinkText, driver);

			MainDashboardPage dashboard = loginPage.LogInAction(
					Constants.PupilLogin2, Constants.PupilPassword);
			assertTrue(dashboard.getImagePhoto());
			// /////////////////////////////////////////////////////////
			EditProfilePage editprof = dashboard.goToEditPage(
					Constants.EditByXPath, driver);

			assertTrue(editprof.checkAvarar());
			assertTrue(editprof.checkPupilName().contains("Шевченко Андрій"));
			InfoProfilePage infoprof = editprof.setLang("English");
			editprof.FindAndClick(Constants.SaveByID, driver);
			assertTrue(infoprof.checkEnglLang().contains(
					"Year of entering: 2013 - 2014"));

		}

	@Test
	public void testSetUpProfilePositive() {

		driver.get(Constants.inetURL);

		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);
		editprof.setSubject("Англійська");
		editprof.setLang("English");

		editprof.clickAllCheckboxes();
		editprof.setOthers("My interest");
		editprof.setAboutMe("Some information about Me");
		editprof.FindAndClick(Constants.SaveByID, driver);

	}

	// Without About me text
	@Test
	public void testSetUpProfilePositive1() {
		driver.get(Constants.inetURL);

		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);
		editprof.setSubject("Програмування");
		editprof.setLang("English");

		editprof.clickAllCheckboxes();
		editprof.setOthers("My interest more and more");
		editprof.setAboutMe();
		editprof.FindAndClick(Constants.SaveByID, driver);
		assertTrue(editprof.checkAboutMe());
	}

	// Without "About me" text and "Interests"
	@Test
	public void testSetUpProfilePositive2() {
		driver.get(Constants.inetURL);

		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);
		editprof.setSubject("Математика");
		editprof.setLang("English");

		editprof.uncheckAllCheckboxes();
		editprof.setAboutMe();
		editprof.FindAndClick(Constants.SaveByID, driver);
		assertTrue(editprof.checkOtherInterest());
		assertTrue(editprof.checkAboutMe());
	}

	// All interest without "Others" is checked and "About me" is set
	@Test
	public void testSetUpProfilePositive3() {
		driver.get(Constants.inetURL);

		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);
		editprof.setSubject("Англійська");
		editprof.setLang("English");
		editprof.clickAllCheckboxes();
		editprof.setOthers();
		editprof.setAboutMe("Some information about Me");
		editprof.FindAndClick(Constants.SaveByID, driver);
		assertTrue(editprof.checkOtherInterestFull());
		assertTrue(editprof.checkAboutMeFull());
	}
	
	@Test
	public void testSetUpProfilePositive4() {

		driver.get(Constants.inetURL);

		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin2, Constants.PupilPassword);

		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);
		editprof.setSubject("Англійська");
		editprof.setLang("English");

		editprof.clickAllCheckboxes();
		editprof.setOthers("My interest");
		editprof.setAboutMe("Some information about Me");
		editprof.FindAndClick(Constants.SaveByID, driver);

	}
	// Without About me text
	@Test
	public void testSetUpProfilePositive5() {
		driver.get(Constants.inetURL);

		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin2, Constants.PupilPassword);

		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);
		editprof.setSubject("Програмування");
		editprof.setLang("English");

		editprof.clickAllCheckboxes();
		editprof.setOthers("My interest more and more");
		editprof.setAboutMe();
		editprof.FindAndClick(Constants.SaveByID, driver);
		assertTrue(editprof.checkAboutMe());
	}

	// Without "About me" text and "Interests"
	@Test
	public void testSetUpProfilePositive6() {
		driver.get(Constants.inetURL);

		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin2, Constants.PupilPassword);

		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);
		editprof.setSubject("Математика");
		editprof.setLang("English");

		editprof.uncheckAllCheckboxes();
		editprof.setAboutMe();
		editprof.FindAndClick(Constants.SaveByID, driver);
		assertTrue(editprof.checkOtherInterest());
		assertTrue(editprof.checkAboutMe());
	}

	// All interest without "Others" is checked and "About me" is set
	@Test
	public void testSetUpProfilePositive7() {
		driver.get(Constants.inetURL);

		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin2, Constants.PupilPassword);

		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);
		editprof.setSubject("Англійська");
		editprof.setLang("English");
		editprof.clickAllCheckboxes();
		editprof.setOthers();
		editprof.setAboutMe("Some information about Me");
		editprof.FindAndClick(Constants.SaveByID, driver);
		assertTrue(editprof.checkOtherInterestFull());
		assertTrue(editprof.checkAboutMeFull());
	}

	@Test
	public void testCheckLinks() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		assertTrue(dashboard.getPupleInfoLink().contains("Іванов Микита"));
		assertTrue(dashboard.getPupleEditLink().contains("Edit"));
		assertTrue(dashboard.getSignOutLink().contains("Sign out"));
		assertTrue(dashboard.getTmInfo().contains("Exigen Agile Practice (c)"));
		assertTrue(dashboard.getAboutDevLink().contains("Developers page"));
		assertTrue(dashboard.getVKLink().contains("VK - group"));
	}

	@Test
	public void testCheckLinks2() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin2, Constants.PupilPassword);

		assertTrue(dashboard.getPupleInfoLink().contains("Шевченко Андрій"));
		assertTrue(dashboard.getPupleEditLink().contains("Edit"));
		assertTrue(dashboard.getSignOutLink().contains("Sign out"));
		assertTrue(dashboard.getTmInfo().contains("Exigen Agile Practice (c)"));
		assertTrue(dashboard.getAboutDevLink().contains("Developers page"));
		assertTrue(dashboard.getVKLink().contains("VK - group"));
	}

	// US#35 Test 35.1.1
	@Test
	public void testMainHeaderExist() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		assertTrue(dashboard.getMainHeader());

	}

	// US#35 test 35.1.2
	@Test
	public void testMenuPanelExist() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		assertTrue(dashboard.checkMenuPanel());

	}

	// US#35 test 35.3.1
	@Test
	public void testAppeatenceOfBlockAboutProfile() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		assertTrue(dashboard.getImagePhoto());
		assertTrue(dashboard.checkNameExist());
		assertTrue(dashboard.checkEditExist());
		assertTrue(dashboard.checkSignOutExist());

	}

	// US#35 test 35.5.1
	@Test
	public void testTransitionToEditPage() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		assertTrue(dashboard.checkNameExist());
		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);

		assertTrue(editprof.checkAvarar());
		assertTrue(editprof.checkPupilURL());

	}

	// US#35 test 35.6.1

	@Test
	public void testTransitionToViewPagePhotoClick() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		assertTrue(dashboard.checkAvatarExist());

		InfoProfilePage infoprof = dashboard.goToInfoPage(
				Constants.InfoPhotoByXPath, driver);

		assertTrue(infoprof.checkInfoPupilURL());

	}

	// US#35 test 35.6.2
	@Test
	public void testTransitionToViewPageByName() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		assertTrue(dashboard.checkAvatarExist());
		assertTrue(dashboard.checkNameExist());

		InfoProfilePage infoprof = dashboard.goToInfoPage(
				Constants.InfoNameByXPath, driver);

		assertTrue(infoprof.checkInfoPupilURL());

	}

	// US#35 tests: 35.8.1; 35.11.1; 35.13.1;

	public void testExistenceOfDashboardTitle() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertTrue(loginPage.checkEmailLabel());
		assertTrue(loginPage.checkTitleLabel());
		assertTrue(loginPage.checkLoginEdit());
		assertTrue(loginPage.checkPasswordEdit());
		assertTrue(loginPage.checkEnterBtn());
		assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		assertTrue(dashboard.checkScheduleTitleExist());
		assertTrue(dashboard.checkClassBookTitleExist());

	}

	// US#35 test 35.7.1
	@Test
	public void testDashboardSchedual() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		assertTrue(dashboard.checkDashboardSchedule());

	}

	// US#35 test 35.7.1
	@Test
	public void testDashboardClassBook() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		assertTrue(dashboard.checkDashboardClassBook());

	}

	// US#35 test 35.7.1
	@Test
	public void testDashboardNews() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		assertTrue(dashboard.checkDashboardNews());

	}

	// US#35 test 35.7.1
	@Test
	public void testDashboardHomework() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		assertTrue(dashboard.checkDashboardHomework());

	}

	// US#35 test 35.7.1
	@Test
	public void testDashboardCircul() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage subm = loginPage.goToLogin(Constants.EnterByLinkText,
				driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		assertTrue(dashboard.checkDashboarCircul());

	}

	// US#35 test 35.4.1; 35.4.2; 35.4.3; 35.4.4;35.4.5 ; 35.4.6;
	@Test
	public void testMainMenuClick() {

		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.FindAndClick(Constants.MyLyseiumByXPath, driver);

		assertTrue(dashboard.checkMainDashURL());

		TeachersPage teachers = dashboard.goToPage(Constants.TeachercByXPath,
				driver);

		assertTrue(teachers.checkTeacherURL());

		OlymliadsPage olymp = dashboard.goToPageOlymp(
				Constants.OlimliadsByXPath, driver);

		assertTrue(olymp.OlymliadsURL());

		EnterancePage enterance = dashboard.goToPageEnterance(
				Constants.EnteranceByXPath, driver);

		assertTrue(enterance.EnteranceURL());

		ContactsPage contacts = dashboard.goToPageContacts(
				Constants.ContactsByXPath, driver);

		assertTrue(contacts.ContactsURL());

	}

	// US#34 tests: 34.0.1;34.1.1; 34.1.2
	@Test
	public void testMainHeaderMainMenuExist() {
		// //////////////////////////////////////////////////////////
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		assertTrue(dashboard.getImagePhoto());
		// /////////////////////////////////////////////////////////
		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);
		assertTrue(dashboard.getMainHeader());
		assertTrue(dashboard.checkMenuPanel());

	}

	// US#34 test 34.8.1
	@Test
	public void testSetRusLang() {
		// //////////////////////////////////////////////////////////
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		assertTrue(dashboard.getImagePhoto());
		// /////////////////////////////////////////////////////////
		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);

		assertTrue(editprof.checkAvarar());
		assertTrue(editprof.checkPupilName().contains("Іванов Микита"));
		InfoProfilePage infoprof = editprof.setLang("Русский");
		editprof.FindAndClick(Constants.SaveByID, driver);
		assertTrue(infoprof.checkEnglLang().contains(
				"Год поступления: 2013 - 2014"));

	}

	// US#34 test 34.8.2
	@Test
	public void testSetUkrLang() {
		// //////////////////////////////////////////////////////////
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		assertTrue(dashboard.getImagePhoto());
		// /////////////////////////////////////////////////////////
		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);

		assertTrue(editprof.checkAvarar());
		assertTrue(editprof.checkPupilName().contains("Іванов Микита"));
		InfoProfilePage infoprof = editprof.setLang("Українська");
		editprof.FindAndClick(Constants.SaveByID, driver);
		assertTrue(infoprof.checkEnglLang().contains("Рік вступу: 2013 - 2014"));

	}

	@Test
	public void testMyLyceumtesSubMenu() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertTrue(loginPage.checkEmailLabel());
		assertTrue(loginPage.checkTitleLabel());
		assertTrue(loginPage.checkLoginEdit());
		assertTrue(loginPage.checkPasswordEdit());
		assertTrue(loginPage.checkEnterBtn());
		assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.checkMyLyceumSubmenu("General info", "My class", "History",
				"Study", "Graduates");
	}

	@Test
	public void testMyTeachersSubmenu() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertTrue(loginPage.checkEmailLabel());
		assertTrue(loginPage.checkTitleLabel());
		assertTrue(loginPage.checkLoginEdit());
		assertTrue(loginPage.checkPasswordEdit());
		assertTrue(loginPage.checkEnterBtn());
		assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.checkTeachersSubmenu("Director", "Directors of studies",
				"Teachers of exact sciences",
				"Teachers of humanitary sciences", "Psychologyst");
	}

	@Test
	public void testMyOlympiadsSubmenu() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertTrue(loginPage.checkEmailLabel());
		assertTrue(loginPage.checkTitleLabel());
		assertTrue(loginPage.checkLoginEdit());
		assertTrue(loginPage.checkPasswordEdit());
		assertTrue(loginPage.checkEnterBtn());
		assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.checkOlympiadsSubmenu("International", "Regional", "State",
				"City", "Lyceum", "Hedgehog", "\"Eurika!\"","\"MAcS\"");

	}

	@Test
	public void testEnteranceSubmenu() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertTrue(loginPage.checkEmailLabel());
		assertTrue(loginPage.checkTitleLabel());
		assertTrue(loginPage.checkLoginEdit());
		assertTrue(loginPage.checkPasswordEdit());
		assertTrue(loginPage.checkEnterBtn());
		assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.checkEnteranceSubmenu("Rules", "Courses", "Tasks");
	}

	@Test
	public void testContactsSubmenu() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertTrue(loginPage.checkEmailLabel());
		assertTrue(loginPage.checkTitleLabel());
		assertTrue(loginPage.checkLoginEdit());
		assertTrue(loginPage.checkPasswordEdit());
		assertTrue(loginPage.checkEnterBtn());
		assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.checkContactsSubmenu("How to find us?", "Preparatory branch",
				"Lyceum and dormitory");
	}

	// US#36 tests 36.2.1 -36.5.1;
	@Test
	public void testTransitionToTheSchedule() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin2, Constants.PupilPassword);

		assertTrue(dashboard.checkDashboardSchedule());
		SchedulePage schedule = dashboard.goToSchedulePage();
		assertTrue(schedule.checkScheduleURL());
		assertTrue(schedule.checkTiele());
		assertTrue(schedule.checkHeader());
		assertTrue(schedule.checkMenuExist());
		assertTrue(schedule.checkPhoto());
		schedule.checkLinks("Шевченко Андрій", "Edit", "Sign out",
				"Developers page", "VK - group", "My Lyceum", "Teachers",
				"Olympiads", "Enterance", "Contacts");

	}
	
	// US#36 tests 36.2.1 -36.5.1;
		@Test
		public void testTransitionToTheSchedule2() {
			driver.get(Constants.inetURL);
			LoginPage loginPage = new LoginPage(driver);
			MainDashboardPage lpage = loginPage.goToLogin(
					Constants.EnterByLinkText, driver);

			MainDashboardPage dashboard = loginPage.LogInAction(
					Constants.PupilLogin, Constants.PupilPassword);

			assertTrue(dashboard.checkDashboardSchedule());
			SchedulePage schedule = dashboard.goToSchedulePage();
			assertTrue(schedule.checkScheduleURL());
			assertTrue(schedule.checkTiele());
			assertTrue(schedule.checkHeader());
			assertTrue(schedule.checkMenuExist());
			assertTrue(schedule.checkPhoto());
			schedule.checkLinks("Іванов Микита", "Edit", "Sign out",
					"Developers page", "VK - group", "My Lyceum", "Teachers",
					"Olympiads", "Enterance", "Contacts");

		}

	// US#36 tests: 36.5.2-36.5.6;
	@Test
	public void testTransitionToTheAllMenuFromSchedulePage() {

		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.FindAndClick(Constants.MyLyseiumByXPath, driver);

		assertTrue(dashboard.checkMainDashURL());

		dashboard.goToSchedulePage();

		TeachersPage teachers = dashboard.goToPage(Constants.TeachercByXPath,
				driver);

		assertTrue(teachers.checkTeacherURL());
		// /////////////////////////////////
		dashboard.FindAndClick(Constants.MyLyseiumByXPath, driver);
		dashboard.goToSchedulePage();
		// ////////////////////////////////

		OlymliadsPage olymp = dashboard.goToPageOlymp(
				Constants.OlimliadsByXPath, driver);

		assertTrue(olymp.OlymliadsURL());

		// /////////////////////////////////
		dashboard.FindAndClick(Constants.MyLyseiumByXPath, driver);
		dashboard.goToSchedulePage();
		// ////////////////////////////////

		EnterancePage enterance = dashboard.goToPageEnterance(
				Constants.EnteranceByXPath, driver);

		assertTrue(enterance.EnteranceURL());

		// /////////////////////////////////
		dashboard.FindAndClick(Constants.MyLyseiumByXPath, driver);
		dashboard.goToSchedulePage();
		// ////////////////////////////////
		ContactsPage contacts = dashboard.goToPageContacts(
				Constants.ContactsByXPath, driver);

		assertTrue(contacts.ContactsURL());

	}
*/
}
