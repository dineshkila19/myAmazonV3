package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.pageobjects.IndexPage;
import com.amazon.utility.Log;

public class IndexPageTest extends BaseClass{
	IndexPage indexPage;
	
	
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
	public void verifyLogo() {
		Log.startTestCase("verifyLogo");
		IndexPage indexPage=new IndexPage();
		Log.info("user is validating myLogo");
		boolean result=indexPage.validateMyLogo();
		Assert.assertTrue(false);
		Log.info("verify Logo testcase is passed");
		Log.endTestCase("verifyLogo");
	}
	
	@Test(groups="Smoke")
	public void getTitle() {
		Log.startTestCase("getTitle");
		IndexPage indexPage=new IndexPage();
		Log.info("user is getting my Title");
		String actTitle=indexPage.getTitle();
		String expTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(actTitle, expTitle);
		Log.info("getMyTitle test case is passed");
		Log.endTestCase("getTitle");
	}

}
