package mmp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstPage {
	WebDriver driver; 
	boolean chk;
	String title;

	public FirstPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public boolean launchURL()
	{
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		boolean chk = true;
		return chk;	
	}

	public boolean wrongURL()
	{
		driver.get("http://96.84.175.78/MM-Release2-Integrated-Build.6.8.000/");
		String error_msg=driver.findElement(By.xpath("html/body/h1")).getText();
		if(error_msg.contains("Not Found"))
		{
			chk = true;
		}
		else 
			chk = false;
		return chk;

	}

	public boolean clickLogin()
	{
		boolean chk;
		driver.findElement(By.xpath("//*[@id='testimonials']//a[text()='Login']")).click();
		if ((driver.findElement(By.id("username")).isDisplayed() == true) 
				&& (driver.findElement(By.id("password")).isDisplayed() == true)
				&& (driver.findElement(By.xpath("//*[@id='login']//a[contains(text(),'forgot')]")).isDisplayed() == true)
				&& (driver.findElement(By.xpath("//*[@id='login']//input[@value='Sign In']")).isDisplayed() == true)
				&& (driver.findElement(By.xpath("//*[@id='login']//input[@value='Register']")).isDisplayed() == true))
			chk = true;
		else chk = false;
		return chk; 

	}
	
	public void clickRegister() throws InterruptedException
	{
		boolean chk;
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='testimonials']/div/div/div/div[3]/a")).click();
		title = driver.getTitle();
		System.out.println(title);
		
		

	}

}
