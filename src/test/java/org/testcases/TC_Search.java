package org.testcases;

import org.newegg.Baseclass;
import org.pom.Pojosearch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_Search extends Baseclass {
	
	@BeforeClass
	public static void setup() {
		browserLaunch();
		maxWindow();
		launchUrl("https://www.newegg.com/");
		
			}
	@AfterClass
	public void closebrowser() {
		driver.quit();
	}
	@Parameters({"pc"})
	@Test
	public void sear(String s1) {
		Pojosearch p=new Pojosearch();
		clk(p.getClose());
		pasTxt(s1, p.getSearch());
		
		
	}
	

}
