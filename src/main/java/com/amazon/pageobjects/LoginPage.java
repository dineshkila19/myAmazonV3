package com.amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(id="ap_email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBtn;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signInBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public HomePage clickOnLogin(String uemail, String pwd) {
		Action.type(txtEmail, uemail);
		Action.click(getDriver(), continueBtn);
		Action.type(txtPassword, pwd);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	
	
	
	

}
