package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.dataprovider.DataProviders;
import com.amazon.pageobjects.HomePage;
import com.amazon.pageobjects.IndexPage;
import com.amazon.pageobjects.LoginPage;
import com.amazon.utility.Log;

public class LoginPageTest extends BaseClass{
	
	
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
	
	@Test(dataProvider = "AmazonLoginData" , dataProviderClass=DataProviders.class , groups= {"Smoke","Sanity"})
	public void loginTest(String uemail , String upwd) {
		Log.startTestCase("loginTest");
		IndexPage indexPage=new IndexPage();
		Log.info("user is going to enter email and password");
		loginPage=indexPage.clickOnHelloSignInBtn();
		//homePage=loginPage.clickOnLogin(prop.getProperty("email"), prop.getProperty("password"));
		homePage=loginPage.clickOnLogin(uemail, upwd);
		Log.info("user successfully enterd credentials");
		String actURL=homePage.getCurrentUrl();
		String curURL="https://www.amazon.in/ap/signin";
		Assert.assertEquals(actURL, curURL);
		Log.info("login test is passed");
		Log.endTestCase("loginTest");
	}
	
	
	
	
	
	
	

}
