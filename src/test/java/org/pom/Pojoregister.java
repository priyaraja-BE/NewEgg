package org.pom;

import org.newegg.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojoregister extends Baseclass{
	
	
	public Pojoregister() {
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="(//i[@class='menu-close ico ico-times'])[2]")	
	private WebElement close;
	
	public WebElement getClose() {
		return close;
	}
	
	@FindBy(xpath="//strong[text()='Sign Up']")
	private WebElement signup;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	private WebElement first;

	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement last;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	private WebElement phn;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement email;
	
	@FindAll({
		@FindBy(xpath="//label[text()='Password']"),
		@FindBy(xpath="(//input[@type='password'])[2]"),
		
	})
	private WebElement pass;

	

	public WebElement getPass() {
		return pass;
	}

	public void setPass(WebElement pass) {
		this.pass = pass;
	}

	public WebElement getSignup() {
		return signup;
	}

	public WebElement getFirst() {
		return first;
	}

	public WebElement getLast() {
		return last;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPhn() {
		return phn;
	}

	
	
	
	
	
	
	
	
}
