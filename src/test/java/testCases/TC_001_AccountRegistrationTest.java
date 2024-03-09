package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass; 
public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups = {"regression","master"})
	public void verify_account_registration()
	{
		logger.info("starting TC_001_AccountRegistrationTest ****** ");
		logger.debug("application logs started.....");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account link ");
		hp.clickRegister();
		logger.info("Clicked on my registiration info link ");
		
		logger.info("Entering customer details");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("clicked on continue...");
		
		String confmsg=regpage.getConfirmationMsg();
		logger.info("Validating expected message..");
		if(confmsg.equals("Your Account Has Been Created!!!"))
		{
			logger.info("test passed....");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed....");
			Assert.fail();
		}
		}catch(Exception e)
		{
			logger.error("test failed..");
			logger.debug("debug logs....");
			Assert.fail();
			
		}
		logger.debug("application logs end.....");
		logger.info("Finished TC_001_AccountRegistrationTest ****** ");
		
		
		
	}
	
	
	

}
