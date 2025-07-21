package Com_Luma_Test_Cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com_Luma__Page_Objects.LUMA_Registration_Page;

public class TC_01_Registration_Page extends LUMA_BaseClass{
	
	public LUMA_Registration_Page LR;
	@Test
	public void RegistrationPage() {
		LR=new LUMA_Registration_Page(driver);
		
		LR.CreateAnAccountLink();
		log.info("Luma Create an Account Clicking Action is Done!");
		
		LR.SetFirstName(rb.getString("FirstName"));
		log.info("First name entered Successfully");
		
		LR.SetLastName(rb.getString("LastName"));
		log.info("Last Name Entered successfully");
		
		LR.SetEmail(rb.getString("Email"));
		log.info("Email Address Entered successfully");
		
		LR.SetPassword(rb.getString("password"));
		log.info("Password Entered successfully");
		
		LR.SetCPassword(rb.getString("ConfirmPassword"));
		log.info("Confirm Password Entered successfully");
		
		LR.clickCreateAnAccount();
		log.info("Registration Done Successfully");
		
//		String Exp_title = "My Account";
//		String Act_title = driver.getTitle();
//		
//		if(Act_title.equals(Exp_title)) {
//			Assert.assertTrue(true);
//			System.out.println("Pass");
//		}else {
//			System.out.println("Fail");
//			Assert.assertTrue(false);
//			
//			
//		}
//		
		
	}

}
