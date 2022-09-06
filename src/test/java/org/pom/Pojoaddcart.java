package org.pom;

import org.newegg.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojoaddcart extends Baseclass{
	public Pojoaddcart() {
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;

	

	@FindBy(xpath="//span[text()='Search']")
	private WebElement searchok;
	
	
	@FindBy(xpath="(//a[text()='Samsung QN75Q70AAFXZA 4K QLED (2021)")
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
