package org.pom;

import org.newegg.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojoaddcart extends Baseclass{
	public Pojoaddcart() {
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="(//i[@class='menu-close ico ico-times'])[2]")	
	private WebElement close;
	
	public WebElement getClose() {
		return close;
	}
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;

	@FindBy(xpath="//span[text()='Search']")
	private WebElement searchok;
	
	
	@FindBy(xpath="(//a[@class='item-title'])[1]")
    private WebElement prod;
	
	@FindBy(xpath="//button[text()='Add to cart ']")
	private WebElement addcart;
	
	
	public WebElement getAddcart() {
		return addcart;
	}

	public WebElement getProd() {
		return prod;
	}

	public void setProd(WebElement prod) {
		this.prod = prod;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearchok() {
		return searchok;
	}
}
