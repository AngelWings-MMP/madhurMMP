package mmp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}

	public boolean informationClick() throws InterruptedException
	{
		boolean chk;
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/ul/li[5]/a/span"))).click();
					
		if(driver.findElement(By.xpath("//div[2]/div/div/div[2]")).isDisplayed() == true)
				
		{
			chk = true;
		}
		else 
			chk = false;
		return chk;

	}
	

}
