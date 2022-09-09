package org.pom;

import org.newegg.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoLogin extends Baseclass{
	
	public PojoLogin() {
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="(//i[@class='menu-close ico ico-times'])[2]")	
	private WebElement close;
	
	public WebElement getClose() {
		return close;
	}

	public void setClose(WebElement close) {
		this.close = close;
	}

	@FindBy(xpath="//div[text()='Sign In / Register']")
	private WebElement signin;
	
	@FindBy(id="labeled-input-signEmail")
	private WebElement email;
	
	
	public WebElement getEmail() {
		return email;
	}

	public WebElement getSignin() {
		return signin;
	}

	
}
