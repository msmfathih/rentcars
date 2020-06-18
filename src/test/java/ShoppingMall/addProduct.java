package ShoppingMall;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class addProduct {

	WebDriver driver; 
	
	
	String projectLocation = System.getProperty("user.dir");

	
	@Parameters("browserName")
	@BeforeTest
	public void  setUpTest(String browserName) {

		
		System.out.println("Browser name is :"+browserName);


		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();

		}else if(browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", projectLocation+"\\Lib\\geckodriver\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\Firefox.exe");	
			driver=new FirefoxDriver();


		}
	}


	@Test(priority=1)
	public void testProduct() throws InterruptedException {
		
		//ExtentTest test = extent.createTest("testProduct", "Fill the required details");
	

		driver.get("https://shoppingmall.multicompetition.com/");
		//test.pass("Navigated demo automationtesting site");
		
		
		// log(Status, details)
		//test.log(Status.INFO, "This step shows usage of log(status, details)");
		
		// info(details)
		//test.info("This step shows usage of info(details)");

		driver.findElement(By.id("email")).sendKeys("ashikamrf71@gmail.com");
		//test.pass("email entered successfully");

		driver.findElement(By.id("password")).sendKeys("ashika@91");

		boolean isEnabled =driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isEnabled();

		if(isEnabled) {

			System.out.println("Login byn is enabled");
		}else {
			System.out.println("Login byn is not enabled");
		}

		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		boolean isTheUsernemPresent = driver.getPageSource().contains("Ashika");
		assertTrue(isTheUsernemPresent);		

		boolean isWelcomeMessage=driver.getPageSource().contains("Welcome to Dahboard!");
		assertTrue(isWelcomeMessage);
		
		//verify product image
		//boolean productImage = driver.findElement(By.xpath("//tr[3]//td[4]//img[1]")).isDisplayed();

		driver.findElement(By.xpath("//a[@class='nav-link']//p[contains(text(),'Products')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();

		

	}


	@Test(priority=2)
	public void addNewProduct() throws InterruptedException {


		Select dropdwn = new Select (driver.findElement(By.xpath("//select[@name='category_id']")));
		dropdwn.selectByVisibleText("Spices");
		System.out.println("Spices has selected");
		
		driver.findElement(By.name("name")).sendKeys("Milk Powder");
		
		driver.findElement(By.id("price")).sendKeys("1500LKR");
	

		String filePath="C:\\Users\\fathih\\eclipse-workspace\\RentVehicals\\images\\milk powder.jpg";
		WebElement uploadButton=driver.findElement(By.xpath("//*[@id=\"image\"]"));
		uploadButton.sendKeys(filePath);
		Thread.sleep(1500);

		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-submit']")).click();
		Thread.sleep(3000);

		boolean isTextDisplayed = driver.getPageSource().contains("Milk Powder");
		assertTrue(isTextDisplayed);
		
		
		boolean isPriceDisplayed = driver.getPageSource().contains("1500LKR");
		assertTrue(isPriceDisplayed);
		
	

	}
	

	@Test(priority=3)
	public void verifyAdminUsers() {
		
		driver.findElement(By.xpath("//p[contains(text(),'Users')]")).click();
		
		boolean isUsernameDisplayed  = driver.getPageSource().contains("Ashfak");
		assertTrue(isUsernameDisplayed);
		
		boolean isUseeEmailDisplayed  = driver.getPageSource().contains("ashfak748@gmail.com");
		assertTrue(isUseeEmailDisplayed);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}

