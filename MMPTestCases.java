package mmp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class MMPTestCases {
	public WebDriver driver;
	FirstPage firstPage;
	LoginPage loginPage;


	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		firstPage = new FirstPage(driver);
		
			}
	
	@Test(priority = 1, description = "Valid URL")
	public void functionalityLaunchURL()
	{
		String url;
		boolean isURLLaunched = firstPage.launchURL();
		Assert.assertTrue(isURLLaunched);
		System.out.println("TC_MMP_PNT_HP_LAUCH_VALID Passed. ");
	}
	
	@Test(priority = 2, description = "InValid URL")
	public void functionalitywrongURL()
	{
		try {
		boolean isURLLaunched = firstPage.wrongURL();
		Assert.assertTrue(isURLLaunched);
		System.out.println("TC_MMP_PNT_HP_LAUCH_INVALID Passed. ");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test(priority = 3, alwaysRun = true, description = "Click Login")
	public void functionalityClickLogin()
	{
		firstPage.launchURL();
		boolean loginClick = firstPage.clickLogin();
		Assert.assertTrue(loginClick);
		System.out.println("TC_MMP_PNT_Login_MMPHomepage Passed. ");
		
	}
	
	@Test(priority = 4, description = "Valid Credentials")
	public void functionalityValidCredenL() throws InterruptedException
	{
		loginPage = new LoginPage(driver);
		boolean chk =loginPage.validCreden();
		Assert.assertTrue(chk);
		System.out.println("TC_MMP_PNT_Login_ValidCredentials Passed. ");
			}
	
	@Test(priority = 5, alwaysRun = true, description = "InValid Credentials")
	public void functionalityInValidCredenL() throws InterruptedException
	{
		loginPage = new LoginPage(driver);
		driver.navigate().back();
		boolean chk = loginPage.inValidCreden();
		Assert.assertTrue(chk);
		System.out.println("TC_MMP_PNT_Login_mismatch Passed. ");
			}
	
	
	
	
}
