package com.exigen.shegula.util;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class SeleniumTest {
	public WebDriver driver;
	public Connection dbConnection;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "selenium-server-url", "selenium-driver-type", "db-url","db-driver", "db-username", "db-password" })
	public void init(String selServerURL, String selDriverType, String dbURL,
			String dbDriver, String username, String password, String dbType)
			throws Exception {
		driver = new RemoteWebDriver(new URL(selServerURL),
				SeleniumConfig.getBrowserDriver(selDriverType));

		DBHelp.getConnection(dbURL, dbDriver, username, password);
		DBHelp.setForumUsers(dbConnection);

	}

	@AfterClass(alwaysRun = true)
	public void destroy() {
		driver.close();
		try {
			dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void signIn(String username, String password, String appURL) {

	}
}
