package org.testcases;
import org.newegg.Baseclass;
import org.pom.PojoLogin;
import org.pom.Pojoregister;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class TC_Register extends Baseclass {
	@BeforeClass
	public static void setup() {
		browserLaunch();
		maxWindow();
		launchUrl("https://www.newegg.com/");
		implicitWait(15);
					}
	@AfterClass
	public void closebrowser() {
		driver.quit();
	}	
    @Test(dataProvider ="regs")
    public void reg(String s1,String s2,String s3,String s4,String s5) throws InterruptedException {
    PojoLogin l=new PojoLogin();
    Pojoregister r=new Pojoregister();
    clk(l.getClose());
    clk(l.getSignin());
   
    clk(r.getSignup());
    pasTxt(s1, r.getFirst());
    pasTxt(s2, r.getLast());
    pasTxt(s3, r.getEmail());
    pasTxt(s4, r.getPhn());
    javaScriptExesendkey(r.getPass(), s5);
            }      	
@DataProvider(name ="regs")	
private Object[][] greens() {
	return new Object[][] {
		{"priya","r","pri@gmail.com","123456788","priya"},
		
};
}
}

