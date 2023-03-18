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
public class HomePage extends BaseClass{
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchProductBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchBoxBtn;
	
	@FindBy(id="glow-ingress-line2")
	WebElement hellowAddress;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateHellowAddress() {
		return Action.isDisplayed(getDriver(), hellowAddress);
	}
	
	public SearchReasultPage searchBox(String text) {
		Action.type(searchProductBox, text);
		Action.click(getDriver(), searchBoxBtn);
		return new SearchReasultPage();
	}
	
	public String getCurrentUrl() {
		String getCurrentUrl1=getDriver().getCurrentUrl();
		return getCurrentUrl1;
	}
	

}
