package test.sample.newproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class FirstMavenExampleTest
{

	WebDriver driver;
	ExtentReports report ;
	ExtentTest test ;
	
	@BeforeTest
	public void init() {
		 report = new ExtentReports("ex-report.html");
		 test = report.startTest("Amazone test", "Testing frontend page of amazon");
	}
	
	@AfterTest
	public void terminate() {
		report.endTest(test);
		report.flush();
	}
	
	@Test
	public void setUp() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Desktop\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement accountAndList=driver.findElement(By.xpath("//a[@id='nav-link-accountList']//span[contains(text(),'Account & Lists')]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(accountAndList).perform();
		try {
			driver.findElement(By.xpath("//a[@class='nav-action-button']/span[text()='Sign in']")).click();
			test.log(LogStatus.PASS	, "Clicking on Sign in button is successfull");
			//log.log();
		}catch(Exception ex) {
			test.log(LogStatus.FAIL	, "Clicking on Sign in button is not successfull");
			throw ex;
		}
		System.out.println("Completed");
		
		driver.close();
		test.log(LogStatus.FAIL, "Unable to close the browser");
		
	}

}
