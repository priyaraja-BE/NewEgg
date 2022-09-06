package org.pom;

import org.newegg.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojoregister extends Baseclass{
	
	
	public Pojoregister() {
		PageFactory.initElements(driver, this);
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
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pass;

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

	public WebElement getPass() {
		return pass;
	}
	
	
	
	
	
	
	
}
