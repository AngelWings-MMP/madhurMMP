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
	HomePage homePage;


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
	
	@Test(priority = 6, description = "Blank Credentials")
	public void functionalityBlankLogin() throws InterruptedException
	{
		loginPage = new LoginPage(driver);
		boolean chk = loginPage.loginBlank();
		Assert.assertTrue(chk);
		System.out.println("TC_MMP_PNT_Login_blank passed. ");
			}
	
	@Test(priority =7, description = "Register Click")
	public void functionalityRegisterClick() throws InterruptedException
	{
		boolean chk;
		firstPage = new FirstPage(driver);
		Thread.sleep(5000);
		//driver.navigate().back();
		String title2 = driver.getTitle();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		
		firstPage.clickRegister();
		if (firstPage.title != title2)
		{
			chk = true;
		}
		else chk = false;
		Assert.assertTrue(chk);
		System.out.println("TC_MMP_PNT_REGISTRATION_OPTIONS passed");
		}
	
	@Test(priority = 8, description = "Information Click")
	public void functionalityInfoClick() throws InterruptedException
	{
		boolean chk;
		homePage = new HomePage(driver);
		driver.navigate().back();
		firstPage.clickLogin();
		loginPage.validCreden();
		Thread.sleep(5000);
		chk = homePage.informationClick();
		Assert.assertTrue(chk);
		System.out.println("TC_MMP_PNT_VIEW_INFO passed");
		}
	
	
	
	
}
