package UserRegistration;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Driver_Registration_VerrifyDetails {

	WebDriver driver;



	@BeforeTest
	public void setUpTest() throws InterruptedException {

		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//implicitlyWait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

		
		driver.get("http://rent.multicompetition.com/login");
		 


	}


	@Test
	public void filOwnerDetails() throws InterruptedException {
		
		 driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
		  Thread.sleep(2000);
		  driver.findElement(By.id("password")).sendKeys("admin@123");

		  



	}




}






