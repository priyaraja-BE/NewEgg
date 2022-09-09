package org.testcases;



import java.io.IOException;
import java.util.Date;

import org.newegg.Baseclass;
import org.pom.PojoLogin;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class TC_Login extends Baseclass {
		
		//SIGNIN PROCESS

		@BeforeClass
		public static void setup() {
			browserLaunch();
			maxWindow();
			}
		@AfterClass
		public void closebrowser() {
			driver.quit();
		}
		@BeforeMethod
		public  static void url() {
			launchUrl("https://www.newegg.com/");
            System.out.println(new Date());
		}
	
		@Test
        public static void Login() throws IOException {
		//ASSERT	
		PojoLogin l=new PojoLogin();
		SoftAssert s=new SoftAssert();
		s.assertTrue(true, "checking..");

		clk(l.getClose());
		clk(l.getSignin());
		pasTxt(readExcel("login","mail", 0, 0),l.getEmail());
		 			
	
		String actual = driver.getTitle();
		System.out.println(actual);
		}
		@AfterMethod
		public  static void date() {
			  System.out.println(new Date());
		
}
}

		
			
		
		
		
		
		
		
		
		

		
		
	

