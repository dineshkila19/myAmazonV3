package com.amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.BaseClass;

public class SearchReasultPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='_bXVsd_content_2rsXy']/div[2]/div[3]/div/div/a/div/img")
	WebElement iphone12WhiteImg;
	
	public SearchReasultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public AddToCartPage selectProduct() {
		Action.click(getDriver(), iphone12WhiteImg);
		return new AddToCartPage();
	}
	
	
	
	
	

}
