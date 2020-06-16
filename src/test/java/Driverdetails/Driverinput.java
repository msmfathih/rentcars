package Driverdetails;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class Driverinput {

    
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;

	
	public static void main(String[] args) throws InterruptedException {
		
		htmlReporter = new ExtentHtmlReporter("extent2.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

			
		String projectLocation = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
				
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
				
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://rent.multicompetition.com/ ");
				
	    //driver.manage().deleteAllCookies();
	    
	    //implicitlyWait
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	    Driverinput.loginModule(driver);
	    
	    String email ;
	    for(int i=0 ; i< 1 ;i++) {
	    	email = "ashikafathih6"+i+"@gmail.com";
	    	
	    	 Driverinput.driverRegistration(driver,email);
	    }
	    
	  
	   //driver.quit();
	   	    
	}
	

	public static void loginModule(WebDriver driver) throws InterruptedException {
		
		ExtentTest test = extent.createTest("fillFormTest", "Fill the required details");
		
		WebElement websiteName = driver.findElement(By.xpath("//*[@id=\"app\"]/nav/div/a"));
		
			
		if(websiteName.isDisplayed()) 
		{
			System.out.println("Name is displayed");
		}
		else {
			System.out.println("Name is not displayed"); 
		}
	
		  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("admin@gmail.com");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin@123");
		  Thread.sleep(3000);
		 			  
		  try {
			  
			  driver.findElement(By.id("btnLogin")).click();
			  System.out.println("Display try");
			  
		  }catch(Exception e) 
		  {
			  System.out.println("Display error");
			  System.out.println(e);
		  }
		  
	}

	
	
	public static void driverRegistration(WebDriver driver,String email) throws InterruptedException {
		
		
		ExtentTest test = extent.createTest("fillFormTest", "Fill the required details");
		
		//click driver button 
		String filePath="C:\\Users\\fathih\\eclipse-workspace\\RentVehicals\\images\\licenece copy.jpeg";
		
		driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/div[4]/div/div/nav/ul/li[2]/a/p")).click();
									 
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/div[4]/div/div/nav/ul/li[2]/ul/li[1]/a/p")).click();
		Thread.sleep(2000);
		
		
		//Register Driver details
		
		//driver name
	    driver.findElement(By.name("name")).sendKeys("ashikafathih");
		Thread.sleep(1500);
		//phone number
		driver.findElement(By.name("mobile_number")).sendKeys("0770728768");
		Thread.sleep(1500);
		//email		 
		driver.findElement(By.name("email")).sendKeys(email);
		Thread.sleep(1500);
		//password		
		driver.findElement(By.name("password")).sendKeys("123456");
		//nic
		Thread.sleep(1500);
		driver.findElement(By.name("nic")).sendKeys("920012213v");
		
		WebElement uploadButton=driver.findElement(By.name("licence_copy"));
		uploadButton.sendKeys(filePath);
		Thread.sleep(1500);
		 		
		WebElement uploadButton1=driver.findElement(By.name("licence_copy_back"));
		uploadButton1.sendKeys(filePath);
		
		driver.findElement(By.name("vehicle_number")).sendKeys("56665656");
		Thread.sleep(1500);
		
		driver.findElement(By.name("is_vehicle_owner")).sendKeys("0");
		Thread.sleep(1500);
		
		
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='vehicle_type_id']")));
	    dropdown.selectByVisibleText("Van");
		
	//	Select select = new Select(driver.findElement(By.xpath("//select")));
//		WebElement option = dropdown.getFirstSelectedOption();
//		String defaultItem = option.getText();
//		System.out.println("im default " );
//		System.out.println(defaultItem );
//		System.out.println("im default " );
		
		//String selectedOption = new Select(driver.findElement(By.xpath("//select[@name='vehicle_type_id']"))).getFirstSelectedOption().getText();

		//dropdown.selectByIndex(2);
		
		WebElement uploadButton2=driver.findElement(By.name("vehicle_picture"));
		uploadButton2.sendKeys(filePath);

		driver.findElement(By.name("engine_number")).sendKeys("123423xd");
		Thread.sleep(1500);
		driver.findElement(By.name("chassis_number")).sendKeys("1sfs");
		Thread.sleep(1500);
		WebElement uploadButton3=driver.findElement(By.name("vehicle_registration_copy"));
		uploadButton3.sendKeys(filePath);
		Thread.sleep(1500);
		WebElement uploadButton4=driver.findElement(By.name("photo"));
		uploadButton4.sendKeys(filePath);
		Thread.sleep(1500);
		driver.findElement(By.name("parking_location")).sendKeys("beruwala");
		Thread.sleep(1500);
		driver.findElement(By.name("prefer_time_from")).sendKeys("10:12 PM");
		Thread.sleep(1500);
		driver.findElement(By.name("prefer_time_to")).sendKeys("12:12 PM");
		Thread.sleep(1500);
		
		Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@name='prefer_location_to_hire']")));
		dropdown2.selectByVisibleText("Islandwide");
		
		
		Thread.sleep(1500);
		//driver.findElement(By.class("btn-submit")).click();
		
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
		  

		extent.flush();
		driver.quit();
      }
		
	}
	
		

	
	
	
	
