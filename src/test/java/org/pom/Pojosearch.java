package org.pom;

import org.newegg.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojosearch extends Baseclass{

	public Pojosearch() {
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;

	@FindBy(xpath="//span[text()='Search']")
	private WebElement searchok;

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearchok() {
		return searchok;
	}
	
}
