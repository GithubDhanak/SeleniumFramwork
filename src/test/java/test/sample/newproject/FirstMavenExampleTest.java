package test.sample.newproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class FirstMavenExampleTest
{
	WebDriver driver;
	int x=10;
	
	@Test
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Desktop\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement accountAndList=driver.findElement(By.xpath("//a[@id='nav-link-accountList']//span[contains(text(),'Account & Lists')]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(accountAndList).perform();
		driver.findElement(By.xpath("//a[@class='nav-action-button']/span[text()='Sign in']")).click();
		System.out.println("Completed");
		//driver.close();
	}

}
