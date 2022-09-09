package org.testcases;

import org.newegg.Baseclass;
import org.pom.Pojoaddcart;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_AddCart extends Baseclass{

	@BeforeClass
	public static void setup() {
		browserLaunch();
		maxWindow();
		launchUrl("https://www.newegg.com/");
		implicitWait(15);
			}
	
		
	@Parameters({"tv"})
	@Test(groups ="smoke")
	public void addCart(@Optional("75inch samsung led tv") String s1) {
		Pojoaddcart a=new Pojoaddcart();
		clk(a.getClose());
		pasTxt(s1, a.getSearch());
		javaScriptExeclk(a.getSearchok());
		javaScriptExeclk(a.getProd());
        javaScriptExeclk(a.getAddcart());
        
}
	@AfterClass
	public void closebrowser() {
		driver.quit();
}
}
	


