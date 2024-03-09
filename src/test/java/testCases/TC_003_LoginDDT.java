package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass
{
	    @Test(dataProvider = "LoginData",dataProviderClass=DataProviders.class)
        public void verify_loginDDT(String email,String password,String exp)
        {
        	logger.info("****Starting  TC_003_LoginDDT  ******");
        	
        	try {
        	 //homepage
       	 HomePage hp=new HomePage(driver);
       	 hp.clickMyAccount();
       	 logger.info("clicked on my account link on the home page");
       	 hp.clickLogin(); //Login link under MyAccount
       	 //logger.info("clicked on login link under myaccount....");
       	 
       	 
       	 //Login page
       	 LoginPage lp=new LoginPage(driver);
       	 //logger.info("Entering valid email and password");
       	 lp.setEmail(email);
       	 lp.setPassword(password);
       	 lp.clickLogin(); //login button
       	 //logger.info("clicked on login button....");
       	 
       	 
       	 //Myaccount page
       	 MyAccountPage macc=new MyAccountPage(driver);
       	 boolean targetPage=macc.isMyAccountPageExists();
       	 
       	 if(exp.equalsIgnoreCase("Valid"))
       	 {
       		 if(targetPage==true)
       		 {
       			 macc.clickLogout();
       			 Assert.assertTrue(true);
       		 }
       		 else
       		 {
       			 Assert.assertTrue(false);
       		 }
       	 }
       	 
       	 if(exp.equalsIgnoreCase("Invalid"))
       	 {
       		 if(targetPage==true)
       		 {
       			macc.clickLogout();
       			Assert.assertTrue(false);
       		 }
       		 else
       		 {
       			 Assert.assertTrue(true);
       		 }
       	 }
        	}catch(Exception e)
        	{
        		Assert.fail();
        	}
        	logger.info("****Finished  TC_003_LoginDDT  ******");
       	 
        }
}
