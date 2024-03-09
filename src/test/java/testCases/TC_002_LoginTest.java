package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;
import pageObjects.*;

public class TC_002_LoginTest extends BaseClass
{
	     @Test(groups = {"sanity","master"})
         public void verify_login()
         {
	    	 logger.info("***** Starting TC_002_LoginTest ****");
        	 logger.debug("capturing application debug logs.....");
	    	 try {
        	 
        	 
        	 //homepage
        	 HomePage hp=new HomePage(driver);
        	 hp.clickMyAccount();
        	 logger.info("clicked on my account link on the home page");
        	 hp.clickLogin(); //Login link under MyAccount
        	 logger.info("clicked on login link under myaccount....");
        	 
        	 
        	 //Login page
        	 LoginPage lp=new LoginPage(driver);
        	 logger.info("Entering valid email and password");
        	 lp.setEmail(p.getProperty("email"));
        	 lp.setPassword(p.getProperty("password"));
        	 lp.clickLogin(); //login button
        	 logger.info("clicked on login button....");
        	 
        	 
        	 //Myaccount page
        	 MyAccountPage macc=new MyAccountPage(driver);
        	 boolean targetPage=macc.isMyAccountPageExists();
        	 if(targetPage==true)
        	 {
        		 logger.info("Login test passed");
        		 Assert.assertTrue(true);
        	 }else
        	 {
        		 logger.error("Login test failed");
        		 Assert.fail();
        	 }
	    	 }catch(Exception e)
	    	 {
	    		 Assert.fail();
	    	 }
        	 logger.info("***** Finished TC_002_LoginTest ****");
        	 
        	 
        	 
         }
}
