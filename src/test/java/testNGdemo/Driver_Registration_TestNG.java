package testNGdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Driver_Registration_TestNG {

	WebDriver driver = null;



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



	@Test
	public void fillForm1() throws InterruptedException {
		
		

		String filePath="C:\\Users\\fathih\\eclipse-workspace\\RentVehicals\\images\\licenece copy.jpeg";
		
		driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/div[4]/div/div/nav/ul/li[2]/a/p/text()")).click();
									 
		 
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/div[4]/div/div/nav/ul/li[2]/ul/li[1]/a/p")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("name")).sendKeys("fathih");
		Thread.sleep(1500);
		//phone number
		driver.findElement(By.name("mobile_number")).sendKeys("0770728768");
		Thread.sleep(1500);
		//email		 
		driver.findElement(By.name("email")).sendKeys("ashika1234@gmail.com");
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

		driver.findElement(By.name("is_vehicle_owner")).sendKeys("1");
		Thread.sleep(1500);


		Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='vehicle_type_id']")));
		dropdown.selectByVisibleText("Van");


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


		Thread.sleep(3000);
		//driver.findElement(By.class("btn-submit")).click();

		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
		
		




	}


	@Test
	public void fillForm2 () throws InterruptedException {

		String filePath="C:\\Users\\fathih\\eclipse-workspace\\RentVehicals\\images\\licenece copy.jpeg";

		driver.findElement(By.name("vehicle_number")).sendKeys("56665656");
		Thread.sleep(1500);

		driver.findElement(By.name("is_vehicle_owner")).sendKeys("1");
		Thread.sleep(1500);


		Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='vehicle_type_id']")));
		dropdown.selectByVisibleText("Van");


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
		

		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();


	}
	
	@AfterTest
	public void tearDown() {
		
		driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/div[4]/div/div/nav/ul/li[3]/a/p")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/div[4]/div/div/nav/ul/li[3]/ul/li/a/p")).click();
		
		
	}

}
