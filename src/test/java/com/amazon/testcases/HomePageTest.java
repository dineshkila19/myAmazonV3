package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.pageobjects.HomePage;
import com.amazon.pageobjects.IndexPage;
import com.amazon.pageobjects.LoginPage;
import com.amazon.utility.Log;

public class HomePageTest extends BaseClass{
	
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Smoke")
	public void verifyHellowAddress() {
		Log.startTestCase("verifyHellowAddress");
		IndexPage  indexPage=new IndexPage();
		Log.info("user is going to click on signin");
		loginPage=indexPage.clickOnHelloSignInBtn();
		homePage=loginPage.clickOnLogin(prop.getProperty("email"), prop.getProperty("password"));
		Log.info("user successfully entered credentials");
		boolean reasult=homePage.validateHellowAddress();
		Assert.assertTrue(reasult);
		Log.info("verifyHellowAddress test is passed");
		Log.endTestCase("verifyHellowAddress");
		
	}
	
	
	
	
	
	

}
