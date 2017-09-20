package mmp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public boolean validCreden() throws InterruptedException
	{
		boolean chk;
		driver.findElement(By.id("username")).sendKeys("T_Jefferson1");
		driver.findElement(By.id("password")).sendKeys("Jefferson@123");
		driver.findElement(By.xpath("//*[@id='login']//input[@value='Sign In']")).sendKeys(Keys.ENTER);	
		Thread.sleep(5000);
		if ((driver.findElement(By.xpath("//li[2]/a/span")).isDisplayed() == true) 
				&& (driver.findElement(By.xpath("//li[3]/a")).isDisplayed() == true)
				&& (driver.findElement(By.xpath("//li[4]/a/span")).isDisplayed() == true)
				&& (driver.findElement(By.xpath("//li[5]/a/span")).isDisplayed() == true)
				&& (driver.findElement(By.xpath("//li[6]/a/span")).isDisplayed() == true)
				&& (driver.findElement(By.xpath("//li[7]/a/span")).isDisplayed() == true)
				&& (driver.findElement(By.xpath("//li[8]/a/span")).isDisplayed() == true)
				&& (driver.findElement(By.xpath("//li[9]/a/span")).isDisplayed() == true)
				&& (driver.findElement(By.xpath("//li[7]/a/span")).isDisplayed() == true)
				&& (driver.findElement(By.xpath("//table")).isDisplayed() == true))
		{
			chk = true;
		}
		else 
			chk = false;
		return chk;

	}
	
	
	public boolean  inValidCreden() throws InterruptedException
	{
		boolean chk;
		driver.findElement(By.id("username")).sendKeys(" Selenium");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='login']//input[@value='Sign In']")).sendKeys(Keys.ENTER);	
		Thread.sleep(5000);
		Alert alrt = driver.switchTo().alert();
		String alertText = alrt.getText();
		if(alertText.contains("Wrong"))
		{
			chk = true;
		}
		else 
			chk = false;
		alrt.accept();		
		
		return chk;
		
	
	}
	
	
	public boolean  loginBlank() throws InterruptedException
	{
		boolean chk;
		String un = driver.findElement(By.id("username")).getText();
		String pw = driver.findElement(By.id("password")).getText();
		driver.findElement(By.xpath("//*[@id='login']//input[@value='Sign In']")).sendKeys(Keys.ENTER);	
		Thread.sleep(5000);
		if ( un.length() == 0 && pw.length() == 0)
		{
			chk = true;
		}
		else 
			chk = false;
			
		return chk;		
	
	}



}
