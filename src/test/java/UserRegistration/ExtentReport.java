package UserRegistration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	private static WebDriver driver = null;
	private static ExtentTest test1;
	private static ExtentReports extent;
	
	public static void main(String[] args) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
  
     // log(Status, details)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
        test1 = extent.createTest("Google search");
        test1.log(Status.INFO, "Starting Test Case");
        
    	String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
        
		 // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        driver.get("https://www.google.com/?hl=en");
        test1.pass("Navigated into Google.com");
        
			
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered text box in text field");
		
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();
     	test1.pass("Pressed Keyboard enter key");
		
		driver.close();
		driver.quit();
		test1.pass("CLosed the browser");
		
		test1.info("Test Completed");
		
		// calling flush writes everything to the log file
        extent.flush();
		
       
        
	}

}
