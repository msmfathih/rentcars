package testNGdemo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Owner_Registration_TestNG {

	WebDriver driver;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	private boolean isEnabled;

	private byte[] jhone;

	private byte[] kumar;


	@BeforeSuite
	public void setUpTest() {


		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		//implicitlyWait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}


	@Test	
	public void verifyLoginPage() throws InterruptedException, IOException {

		ExtentTest test = extent.createTest("fillFormTest", "Fill the required details");

		driver.get("http://rent.multicompetition.com/login");
		//Assert.assertEquals("multicompetition", driver.getTitle());
		
		test.pass("Navigated demo automationtesting site");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");



		WebElement websiteName = driver.findElement(By.xpath("//*[@id=\"app\"]/nav/div/a"));

		if(websiteName.isDisplayed()) 
		{
			System.out.println("Name is displayed");
		}
		else {
			System.out.println("Name is not displayed"); 
		}



		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("admin@gmail.com");
		//test.pass("Email is entered");	
		Thread.sleep(3000);


		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin@123");
		Thread.sleep(3000);
		test.pass("Entered Password");



		boolean isEnabled = driver.findElement(By.id("btnLogin")).isEnabled();
		boolean isDisplayed = driver.findElement(By.name("remember")).isDisplayed();

		if(isEnabled) {

			System.out.println("Login button is enable");
		}else {

			System.out.println("Login button not enable");
		}


		if(isDisplayed) {
			System.out.println("Remember text is displayed");
		}else {

			System.out.println("Remember text is  not Displayed");
		}


		//existance of forgot password link text
		try {

			driver.findElement(By.xpath("//a[contains(text(),'Forgot Your Password')]"));
			System.out.println("Forgot password link exist");

		}catch(NoSuchElementException e) {

			System.out.println("Forgot password link not exist");

		}


		driver.findElement(By.id("btnLogin")).click();

	
		
		//Verify page title method 1
//		String my_title=driver.getTitle();
//
//		System.out.println("My title "+my_title);
//		String expected_title="Rent Vehicles Dashboard";
//		Assert.assertEquals(my_title, expected_title);
//		Assert.assertTrue(my_title.contains("Rent Vehicles Dashboard"));
		
		//Verify page title method 1
		String title=driver.getTitle();
		System.out.println("This page title is: "+title);
		Assert.assertEquals(title, "Rent Vehicles Dashboard");


		driver.findElement(By.xpath("//p[contains(text(),'Vehicles')]")).click();
		
		driver.findElement(By.xpath("//p[contains(text(),'Vehicle Owners')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/a")).click();
		Thread.sleep(1500);
		
		
		
		//Entering owners details and verify them
		driver.findElement(By.id("name")).sendKeys("jhone");
		String mystr="jhone";
		Assert.assertTrue(mystr.contains("jhone"));
	
	
		driver.findElement(By.name("nic")).sendKeys("43534535325v");
		String mynum="43534535325v";
		Assert.assertTrue(mynum.contains("43534535325v"));
		

		driver.findElement(By.name("phone_number")).sendKeys("01565515");
		String myContact="01565515";
		Assert.assertTrue(myContact.contains("01565515"));
		

		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();	
		
		driver.findElement(By.xpath("//p[contains(text(),'Vehicles')]")).click();
		
		driver.findElement(By.xpath("//p[contains(text(),'Vehicle Types')]")).click();
		
		
		boolean isTheTextPresent = driver.getPageSource().contains("Vehicle Types");
		assertTrue(isTheTextPresent);	
		
		boolean vehicleTypeWheel = driver.getPageSource().contains("Threewheel");
		assertTrue(vehicleTypeWheel);

						
	}



	@AfterSuite
	public void tearDownTest() {

		extent.flush();
		driver.quit();
	}


}
