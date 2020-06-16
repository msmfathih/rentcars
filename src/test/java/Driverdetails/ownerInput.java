package Driverdetails;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class ownerInput {

    
	public static void main(String[] args) throws InterruptedException {
		
		
		String projectLocation = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
				
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
				
		WebDriver driver = new ChromeDriver();
		driver.get("http://rent.multicompetition.com/login");
				
	    //driver.manage().deleteAllCookies();
	    
	    //implicitlyWait
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	    ownerInput.loginModule(driver);
	    
	    ownerInput.ownerRegistration(driver);
	    	
	    Thread.sleep(1500);
	    driver.quit();
	   	    
	}
	

	public static void loginModule(WebDriver driver) throws InterruptedException {
		
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

	public static void ownerRegistration(WebDriver driver) throws InterruptedException {
		
		
		driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/div[4]/div/div/nav/ul/li[1]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/div[4]/div/div/nav/ul/li[1]/ul/li[1]/a")).click();
									
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/a")).click();
		Thread.sleep(1500);
		
		driver.findElement(By.id("name")).sendKeys("Test1");
		Thread.sleep(1500);
		
		driver.findElement(By.name("nic")).sendKeys("43534535325v");
		Thread.sleep(1500);
		
		driver.findElement(By.name("phone_number")).sendKeys("01565515");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/section/div[1]/div/form/div[2]/button")).click();
		
		
			  
		
      }
		
	}
	
		

	
	
	
	
