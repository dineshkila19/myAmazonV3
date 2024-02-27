package com.amazon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.dataprovider.DataProviders;
import com.amazon.pageobjects.AddToCartPage;
import com.amazon.pageobjects.HomePage;
import com.amazon.pageobjects.IndexPage;
import com.amazon.pageobjects.LoginPage;
import com.amazon.pageobjects.SearchReasultPage;
import com.amazon.utility.Log;

public class SearchReasultPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchReasultPage searchReasultPage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(dataProvider="ProductName" , dataProviderClass=DataProviders.class ,  groups="Regression")
	public void selectProductTest(String uproduct) {
		Log.startTestCase("selectProductTest");
		IndexPage indexPage=new IndexPage();
		Log.info("user is going to click on signin");
		loginPage=indexPage.clickOnHelloSignInBtn();
		homePage=loginPage.clickOnLogin(prop.getProperty("email"), prop.getProperty("password"));
		//homePage=loginPage.clickOnLogin(uemail, upwd);
		Log.info("user successfully entered credentials");
		searchReasultPage=homePage.searchBox(uproduct);
		Log.info("user successfully entered iphone 12");
		addToCartPage=searchReasultPage.selectProduct();
		Log.info("selectProductTest is passed");
		Log.endTestCase("selectProductTest");
		
	}
	
	
	
	
	
	
	
	
	
	

}
