/**
 * 
 */
package com.exigen.shegula.tests;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

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
import com.exigen.shegula.util.Constants;

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

	// US#34 test 34.8.3
	@Test
	public void testSetEngLangPupil() {
		// //////////////////////////////////////////////////////////
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		Assert.assertTrue(dashboard.getImagePhoto());
		// /////////////////////////////////////////////////////////
		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);

		Assert.assertTrue(editprof.checkAvarar());
		Assert.assertTrue(editprof.checkPupilName().contains("Іванов Микита"));
		InfoProfilePage infoprof = editprof.setLang("English");
		editprof.FindAndClick(Constants.SaveByID, driver);
		Assert.assertTrue(infoprof.checkEnglLang().contains(
				"Year of entering: 2013 - 2014"));

	}
	// US#34 test 34.8.3
		@Test
		public void testSetEngLang2Pupil() {
			// //////////////////////////////////////////////////////////
			driver.get(Constants.inetURL);
			LoginPage loginPage = new LoginPage(driver);

			MainDashboardPage lpage = loginPage.goToLogin(
					Constants.EnterByLinkText, driver);

			MainDashboardPage dashboard = loginPage.LogInAction(
					Constants.PupilLogin2, Constants.PupilPassword);
			Assert.assertTrue(dashboard.getImagePhoto());
			// /////////////////////////////////////////////////////////
			EditProfilePage editprof = dashboard.goToEditPage(
					Constants.EditByXPath, driver);

			Assert.assertTrue(editprof.checkAvarar());
			Assert.assertTrue(editprof.checkPupilName().contains("Шевченко Андрій"));
			InfoProfilePage infoprof = editprof.setLang("English");
			editprof.FindAndClick(Constants.SaveByID, driver);
			Assert.assertTrue(infoprof.checkEnglLang().contains(
					"Year of entering: 2013 - 2014"));

		}

	@Test
	public void testSetUpProfilePositivePupil() {

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
	public void testSetUpProfilePositive1Pupil() {
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
		Assert.assertTrue(editprof.checkAboutMe());
	}

	// Without "About me" text and "Interests"
	@Test
	public void testSetUpProfilePositive2Pupil() {
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
		Assert.assertTrue(editprof.checkOtherInterest());
		Assert.assertTrue(editprof.checkAboutMe());
	}

	// All interest without "Others" is checked and "About me" is set
	@Test
	public void testSetUpProfilePositive3Pupil() {
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
		Assert.assertTrue(editprof.checkOtherInterestFull());
		Assert.assertTrue(editprof.checkAboutMeFull());
	}
	
	@Test
	public void testSetUpProfilePositive4Pupil() {

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
	public void testSetUpProfilePositive5Pupil() {
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
		Assert.assertTrue(editprof.checkAboutMe());
	}

	// Without "About me" text and "Interests"
	@Test
	public void testSetUpProfilePositive6Pupil() {
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
		Assert.assertTrue(editprof.checkOtherInterest());
		Assert.assertTrue(editprof.checkAboutMe());
	}

	// All interest without "Others" is checked and "About me" is set
	@Test
	public void testSetUpProfilePositive7Pupil() {
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
		Assert.assertTrue(editprof.checkOtherInterestFull());
		Assert.assertTrue(editprof.checkAboutMeFull());
	}

	@Test
	public void testCheckLinksPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		Assert.assertTrue(dashboard.getPupleInfoLink().contains("Іванов Микита"));
		Assert.assertTrue(dashboard.getPupleEditLink().contains("Edit"));
		Assert.assertTrue(dashboard.getSignOutLink().contains("Sign out"));
		Assert.assertTrue(dashboard.getTmInfo().contains("Exigen Agile Practice (c)"));
		Assert.assertTrue(dashboard.getAboutDevLink().contains("Developers page"));
		Assert.assertTrue(dashboard.getVKLink().contains("VK - group"));
	}

	@Test
	public void testCheckLinks2Pupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin2, Constants.PupilPassword);

		Assert.assertTrue(dashboard.getPupleInfoLink().contains("Шевченко Андрій"));
		Assert.assertTrue(dashboard.getPupleEditLink().contains("Edit"));
		Assert.assertTrue(dashboard.getSignOutLink().contains("Sign out"));
		Assert.assertTrue(dashboard.getTmInfo().contains("Exigen Agile Practice (c)"));
		Assert.assertTrue(dashboard.getAboutDevLink().contains("Developers page"));
		Assert.assertTrue(dashboard.getVKLink().contains("VK - group"));
	}

	// US#35 Test 35.1.1
	@Test
	public void testMainHeaderExistPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		Assert.assertTrue(dashboard.getMainHeader());

	}

	// US#35 test 35.1.2
	@Test
	public void testMenuPanelExistPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		Assert.assertTrue(dashboard.checkMenuPanel());

	}

	// US#35 test 35.3.1
	@Test
	public void testAppeatenceOfBlockAboutProfilePupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		Assert.assertTrue(dashboard.getImagePhoto());
		Assert.assertTrue(dashboard.checkNameExist());
		Assert.assertTrue(dashboard.checkEditExist());
		Assert.assertTrue(dashboard.checkSignOutExist());

	}

	// US#35 test 35.5.1
	@Test
	public void testTransitionToEditPagePupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		Assert.assertTrue(dashboard.checkNameExist());
		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);

		Assert.assertTrue(editprof.checkAvarar());
		Assert.assertTrue(editprof.checkPupilURL());

	}

	// US#35 test 35.6.1

	@Test
	public void testTransitionToViewPagePhotoClickPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		Assert.assertTrue(dashboard.checkAvatarExist());

		InfoProfilePage infoprof = dashboard.goToInfoPage(
				Constants.InfoPhotoByXPath, driver);

		Assert.assertTrue(infoprof.checkInfoPupilURL());

	}

	// US#35 test 35.6.2
	@Test
	public void testTransitionToViewPageByNamePupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		Assert.assertTrue(dashboard.checkAvatarExist());
		Assert.assertTrue(dashboard.checkNameExist());

		InfoProfilePage infoprof = dashboard.goToInfoPage(
				Constants.InfoNameByXPath, driver);

		Assert.assertTrue(infoprof.checkInfoPupilURL());

	}

	// US#35 tests: 35.8.1; 35.11.1; 35.13.1;

	public void testExistenceOfDashboardTitlePupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(loginPage.checkEmailLabel());
		Assert.assertTrue(loginPage.checkTitleLabel());
		Assert.assertTrue(loginPage.checkLoginEdit());
		Assert.assertTrue(loginPage.checkPasswordEdit());
		Assert.assertTrue(loginPage.checkEnterBtn());
		Assert.assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		Assert.assertTrue(dashboard.checkScheduleTitleExist());
		Assert.assertTrue(dashboard.checkClassBookTitleExist());

	}

	// US#35 test 35.7.1
	@Test
	public void testDashboardSchedualPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		Assert.assertTrue(dashboard.checkDashboardSchedule());

	}

	// US#35 test 35.7.1
	@Test
	public void testDashboardClassBookPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		Assert.assertTrue(dashboard.checkDashboardClassBook());

	}

	// US#35 test 35.7.1
	@Test
	public void testDashboardNewsPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		Assert.assertTrue(dashboard.checkDashboardNews());

	}

	// US#35 test 35.7.1
	@Test
	public void testDashboardHomeworkPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		Assert.assertTrue(dashboard.checkDashboardHomework());

	}

	// US#35 test 35.7.1
	@Test
	public void testDashboardCirculPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage subm = loginPage.goToLogin(Constants.EnterByLinkText,
				driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		Assert.assertTrue(dashboard.checkDashboarCircul());

	}

	// US#35 test 35.4.1; 35.4.2; 35.4.3; 35.4.4;35.4.5 ; 35.4.6;
	@Test
	public void testMainMenuClickPupil() {

		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.FindAndClick(Constants.MyLyseiumByXPath, driver);

		Assert.assertTrue(dashboard.checkMainDashURL());

		TeachersPage teachers = dashboard.goToPage(Constants.TeachercByXPath,
				driver);

		Assert.assertTrue(teachers.checkTeacherURL());

		OlymliadsPage olymp = dashboard.goToPageOlymp(
				Constants.OlimliadsByXPath, driver);

		Assert.assertTrue(olymp.OlymliadsURL());

		EnterancePage enterance = dashboard.goToPageEnterance(
				Constants.EnteranceByXPath, driver);

		Assert.assertTrue(enterance.EnteranceURL());

		ContactsPage contacts = dashboard.goToPageContacts(
				Constants.ContactsByXPath, driver);

		Assert.assertTrue(contacts.ContactsURL());

	}

	// US#34 tests: 34.0.1;34.1.1; 34.1.2
	@Test
	public void testMainHeaderMainMenuExistPupil() {
		// //////////////////////////////////////////////////////////
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		Assert.assertTrue(dashboard.getImagePhoto());
		// /////////////////////////////////////////////////////////
		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);
		Assert.assertTrue(dashboard.getMainHeader());
		Assert.assertTrue(dashboard.checkMenuPanel());

	}

	// US#34 test 34.8.1
	@Test
	public void testSetRusLangPupil() {
		// //////////////////////////////////////////////////////////
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		Assert.assertTrue(dashboard.getImagePhoto());
		// /////////////////////////////////////////////////////////
		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);

		Assert.assertTrue(editprof.checkAvarar());
		Assert.assertTrue(editprof.checkPupilName().contains("Іванов Микита"));
		InfoProfilePage infoprof = editprof.setLang("Русский");
		editprof.FindAndClick(Constants.SaveByID, driver);
		Assert.assertTrue(infoprof.checkEnglLang().contains(
				"Год поступления: 2013 - 2014"));

	}

	// US#34 test 34.8.2
	@Test
	public void testSetUkrLangPupil() {
		// //////////////////////////////////////////////////////////
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);
		Assert.assertTrue(dashboard.getImagePhoto());
		// /////////////////////////////////////////////////////////
		EditProfilePage editprof = dashboard.goToEditPage(
				Constants.EditByXPath, driver);

		Assert.assertTrue(editprof.checkAvarar());
		Assert.assertTrue(editprof.checkPupilName().contains("Іванов Микита"));
		InfoProfilePage infoprof = editprof.setLang("Українська");
		editprof.FindAndClick(Constants.SaveByID, driver);
		Assert.assertTrue(infoprof.checkEnglLang().contains("Рік вступу: 2013 - 2014"));

	}

	@Test
	public void testMyLyceumtesSubMenuPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(loginPage.checkEmailLabel());
		Assert.assertTrue(loginPage.checkTitleLabel());
		Assert.assertTrue(loginPage.checkLoginEdit());
		Assert.assertTrue(loginPage.checkPasswordEdit());
		Assert.assertTrue(loginPage.checkEnterBtn());
		Assert.assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.checkMyLyceumSubmenu("General info", "My class", "History",
				"Study", "Graduates");
	}

	@Test
	public void testMyTeachersSubmenuPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(loginPage.checkEmailLabel());
		Assert.assertTrue(loginPage.checkTitleLabel());
		Assert.assertTrue(loginPage.checkLoginEdit());
		Assert.assertTrue(loginPage.checkPasswordEdit());
		Assert.assertTrue(loginPage.checkEnterBtn());
		Assert.assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.checkTeachersSubmenu("Director", "Directors of studies",
				"Teachers of exact sciences",
				"Teachers of humanitary sciences", "Psychologyst");
	}

	@Test
	public void testMyOlympiadsSubmenuPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(loginPage.checkEmailLabel());
		Assert.assertTrue(loginPage.checkTitleLabel());
		Assert.assertTrue(loginPage.checkLoginEdit());
		Assert.assertTrue(loginPage.checkPasswordEdit());
		Assert.assertTrue(loginPage.checkEnterBtn());
		Assert.assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.checkOlympiadsSubmenu("International", "Regional", "State",
				"City", "Lyceum", "Hedgehog", "\"Eurika!\"","\"MAcS\"");

	}

	@Test
	public void testEnteranceSubmenuPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(loginPage.checkEmailLabel());
		Assert.assertTrue(loginPage.checkTitleLabel());
		Assert.assertTrue(loginPage.checkLoginEdit());
		Assert.assertTrue(loginPage.checkPasswordEdit());
		Assert.assertTrue(loginPage.checkEnterBtn());
		Assert.assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.checkEnteranceSubmenu("Rules", "Courses", "Tasks");
	}

	@Test
	public void testContactsSubmenuPupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);

		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(loginPage.checkEmailLabel());
		Assert.assertTrue(loginPage.checkTitleLabel());
		Assert.assertTrue(loginPage.checkLoginEdit());
		Assert.assertTrue(loginPage.checkPasswordEdit());
		Assert.assertTrue(loginPage.checkEnterBtn());
		Assert.assertTrue(loginPage.checkRegLink());

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.checkContactsSubmenu("How to find us?", "Preparatory branch",
				"Lyceum and dormitory");
	}

	// US#36 tests 36.2.1 -36.5.1;
	@Test
	public void testTransitionToTheSchedulePupil() {
		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin2, Constants.PupilPassword);

		Assert.assertTrue(dashboard.checkDashboardSchedule());
		SchedulePage schedule = dashboard.goToSchedulePage();
		Assert.assertTrue(schedule.checkScheduleURL());
		Assert.assertTrue(schedule.checkTiele());
		Assert.assertTrue(schedule.checkHeader());
		Assert.assertTrue(schedule.checkMenuExist());
		Assert.assertTrue(schedule.checkPhoto());
		schedule.checkLinks("Шевченко Андрій", "Edit", "Sign out",
				"Developers page", "VK - group", "My Lyceum", "Teachers",
				"Olympiads", "Enterance", "Contacts");

	}
	
	// US#36 tests 36.2.1 -36.5.1;
		@Test
		public void testTransitionToTheSchedule2Pupil() {
			driver.get(Constants.inetURL);
			LoginPage loginPage = new LoginPage(driver);
			MainDashboardPage lpage = loginPage.goToLogin(
					Constants.EnterByLinkText, driver);

			MainDashboardPage dashboard = loginPage.LogInAction(
					Constants.PupilLogin, Constants.PupilPassword);

			Assert.assertTrue(dashboard.checkDashboardSchedule());
			SchedulePage schedule = dashboard.goToSchedulePage();
			Assert.assertTrue(schedule.checkScheduleURL());
			Assert.assertTrue(schedule.checkTiele());
			Assert.assertTrue(schedule.checkHeader());
			Assert.assertTrue(schedule.checkMenuExist());
			Assert.assertTrue(schedule.checkPhoto());
			schedule.checkLinks("Іванов Микита", "Edit", "Sign out",
					"Developers page", "VK - group", "My Lyceum", "Teachers",
					"Olympiads", "Enterance", "Contacts");

		}

	// US#36 tests: 36.5.2-36.5.6;
	@Test
	public void testTransitionToTheAllMenuFromSchedulePagePupil() {

		driver.get(Constants.inetURL);
		LoginPage loginPage = new LoginPage(driver);
		MainDashboardPage lpage = loginPage.goToLogin(
				Constants.EnterByLinkText, driver);

		MainDashboardPage dashboard = loginPage.LogInAction(
				Constants.PupilLogin, Constants.PupilPassword);

		dashboard.FindAndClick(Constants.MyLyseiumByXPath, driver);

		Assert.assertTrue(dashboard.checkMainDashURL());

		dashboard.goToSchedulePage();

		TeachersPage teachers = dashboard.goToPage(Constants.TeachercByXPath,
				driver);

		Assert.assertTrue(teachers.checkTeacherURL());
		// /////////////////////////////////
		dashboard.FindAndClick(Constants.MyLyseiumByXPath, driver);
		dashboard.goToSchedulePage();
		// ////////////////////////////////

		OlymliadsPage olymp = dashboard.goToPageOlymp(
				Constants.OlimliadsByXPath, driver);

		Assert.assertTrue(olymp.OlymliadsURL());

		// /////////////////////////////////
		dashboard.FindAndClick(Constants.MyLyseiumByXPath, driver);
		dashboard.goToSchedulePage();
		// ////////////////////////////////

		EnterancePage enterance = dashboard.goToPageEnterance(
				Constants.EnteranceByXPath, driver);

		Assert.assertTrue(enterance.EnteranceURL());

		// /////////////////////////////////
		dashboard.FindAndClick(Constants.MyLyseiumByXPath, driver);
		dashboard.goToSchedulePage();
		// ////////////////////////////////
		ContactsPage contacts = dashboard.goToPageContacts(
				Constants.ContactsByXPath, driver);

		Assert.assertTrue(contacts.ContactsURL());

	}

}
