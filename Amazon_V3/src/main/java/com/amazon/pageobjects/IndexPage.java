/**
 * 
 */
package com.amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.BaseClass;

/**
 * @author Dinesh
 *
 */
public class IndexPage extends BaseClass{
	
	@FindBy(id="nav-logo-sprites")
	WebElement logo;
	
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	WebElement helloSigninBtn;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyLogo() {
		return Action.isDisplayed(getDriver(), logo);
		
	}
	
	public String getTitle() {
		String myTitle1=getDriver().getTitle();
		return myTitle1;
		
	}
	
	public LoginPage clickOnHelloSignInBtn() {
		Action.click(getDriver(), helloSigninBtn);
		return new LoginPage();
	}
	

}
