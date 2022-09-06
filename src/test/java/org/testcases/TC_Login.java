package org.testcases;



import java.io.IOException;

import org.newegg.Baseclass;
import org.pom.PojoLogin;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class TC_Login extends Baseclass {

	
		
		//SIGNIN PROCESS

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
	
		@Test
        public static void Login() throws IOException {
			//ASSERT	
		PojoLogin l=new PojoLogin();
		SoftAssert s=new SoftAssert();
		s.assertTrue(true, "checking..");

		
		clk(l.getSignin());
		pasTxt(readExcel("login","mail", 0, 0),l.getEmail());
		 			
	
		String actual = driver.getTitle();
		System.out.println(actual);
		
}
}

		
			
		
		
		
		
		
		
		
		

		
		
	

